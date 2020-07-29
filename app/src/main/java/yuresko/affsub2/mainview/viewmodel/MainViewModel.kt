package yuresko.affsub2.mainview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import yuresko.affsub2.base.BaseViewModel
import yuresko.affsub2.mainview.model.ItemModel
import yuresko.affsub2.mainview.model.MainViewState
import yuresko.affsub2.repository.IRepository
import yuresko.affsub2.utils.addTo

interface IMainViewModel {

    val state: LiveData<MainViewState>

    fun fetchInfo()
}

class MainViewModel(private val repository: IRepository) : BaseViewModel(), IMainViewModel {

    override val state: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        fetchInfo()
    }

    override fun fetchInfo() {
        repository
            .getRandomUser()
            .map { list ->
                list.results.map { entity ->
                    ItemModel(
                        entity.picture.large,
                        entity.name.first,
                        entity.name.last,
                        entity.dob.age,
                        entity.phone,
                        entity.email,
                        entity.login.username
                    )
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                state.postValue(MainViewState.Loading)
            }
            .subscribe({
                state.postValue(MainViewState.LoadInfo(it))
            }, {
                state.postValue(MainViewState.Error(it))
            })
            .addTo(compositeDisposable)
    }
}
package yuresko.affsub2.mainview.model

sealed class MainViewState {

    object Loading : MainViewState()

    data class LoadInfo(
        val user: List<ItemModel>
    ) : MainViewState()

    data class Error(
        val error: Throwable
    ) : MainViewState()
}
package yuresko.affsub2.mainview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import yuresko.affsub2.App
import yuresko.affsub2.R
import yuresko.affsub2.adapter.UsersListAdapter
import yuresko.affsub2.mainview.model.MainViewState
import yuresko.affsub2.mainview.viewmodel.IMainViewModel
import yuresko.affsub2.mainview.viewmodel.MainViewModel
import yuresko.affsub2.repository.IRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val adapter = UsersListAdapter(this)
    private lateinit var recycler: RecyclerView

    lateinit var viewModel: IMainViewModel

    @Inject
    lateinit var repository: IRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerView)

        supportActionBar?.title = "Home"

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }).get(MainViewModel::class.java)

        recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        button.setOnClickListener { viewModel.fetchInfo() }

        observeData()
    }

    private fun observeData() {
        viewModel.state.observe(this, Observer { state ->
            when (state) {
                MainViewState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                is MainViewState.LoadInfo -> {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    recycler.adapter = adapter
                    adapter.submitList(state.user)
                }
                is MainViewState.Error -> {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.GONE
                    Toast.makeText(this, state.error.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}
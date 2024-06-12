package com.example.tmdb_project.presentation.tv

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb_project.R
import com.example.tmdb_project.databinding.ActivityTvShowBinding
import com.example.tmdb_project.presentation.di.Injector
import com.example.tmdb_project.presentation.movie.MovieAdapter
import com.example.tmdb_project.presentation.movie.MovieViewModel
import com.example.tmdb_project.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding

    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var adapter: TvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel= ViewModelProvider(this,factory)
            .get(TvShowViewModel::class.java)

        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.tvShowRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = TvAdapter()
        binding.tvShowRecyclerview.adapter = adapter
        displayPopularTvShows()

    }

    private fun displayPopularTvShows(){

        binding.tvShowProgressBar.visibility = View.VISIBLE

        val responseLiveData = tvShowViewModel.getTvShows()

        responseLiveData.observe(this, Observer {

            Log.i("MYTAG",it.toString())
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }else{
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No Data Found", Toast.LENGTH_LONG).show()
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.action_update ->{
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

//        return super.onOptionsItemSelected(item)
    }

    private fun updateTvShows(){
        binding.tvShowProgressBar.visibility = View.VISIBLE

        val response = tvShowViewModel.updateTvShows()
        response.observe(this, Observer {

            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }
            else{
                binding.tvShowProgressBar.visibility = View.GONE
            }

        })
    }

}
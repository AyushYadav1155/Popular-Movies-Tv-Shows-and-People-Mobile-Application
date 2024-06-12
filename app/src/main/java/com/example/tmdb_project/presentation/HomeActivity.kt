package com.example.tmdb_project.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tmdb_project.R
import com.example.tmdb_project.databinding.ActivityHomeBinding
import com.example.tmdb_project.presentation.artist.ArtistActivity
import com.example.tmdb_project.presentation.movie.MovieActivity
import com.example.tmdb_project.presentation.tv.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.movieButton.setOnClickListener{
            val intent = Intent(this,MovieActivity::class.java)
            startActivity(intent)

//            startActivity(Intent(this,MovieActivity::class.java))
//            this@HomeActivity.overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        }

        binding.tvButton.setOnClickListener{
            val intent = Intent(this,TvShowActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener{
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

    }
}
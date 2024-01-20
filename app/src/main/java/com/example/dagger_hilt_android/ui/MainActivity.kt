package com.example.dagger_hilt_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.dagger_hilt_android.databinding.ActivityMainBinding
import com.example.dagger_hilt_android.retrofit.AlbumResponseState
import com.example.dagger_hilt_android.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.newCoroutineContext
import kotlinx.coroutines.withContext

/**
 * [MainActivity] is the main screen of the application.
 * I have to annotate [MainActivity] with AndroidEntryPoint to add into the Hilt System
 *
 * Warning : Please do not use the modifier private on a variable
 * if you are going to use the variable in Hilt System
 *
 * */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    /**
     * onCreate callback method of the Activity
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAlbums()
    }

    private fun getAlbums() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.albumState.collectLatest { state ->
                    when (state) {
                        is AlbumResponseState.Loading -> binding.progressBar.visibility =
                            View.VISIBLE

                        is AlbumResponseState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this@MainActivity, state.message, Toast.LENGTH_LONG)
                                .show()
                            val albums = state.albums
                            for (album in albums) {
                                println(album.title)
                            }
                        }

                        is AlbumResponseState.Failed -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(
                                this@MainActivity,
                                state.error.message,
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    }
                }
            }
        }
    }
}
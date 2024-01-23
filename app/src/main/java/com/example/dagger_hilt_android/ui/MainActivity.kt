package com.example.dagger_hilt_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.dagger_hilt_android.adapter.AlbumAdapter
import com.example.dagger_hilt_android.databinding.ActivityMainBinding
import com.example.dagger_hilt_android.model.Album
import com.example.dagger_hilt_android.model.Retailer
import com.example.dagger_hilt_android.retrofit.AlbumResponseState
import com.example.dagger_hilt_android.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

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

    // Used this object for demonstrating the feature of Dagger Hilt
    @Inject
    lateinit var retailer: Retailer
    private lateinit var adapter: AlbumAdapter
    private var albums: MutableList<Album> = emptyList<Album>().toMutableList()
    private val handler = Handler(Looper.getMainLooper())
    private val viewModel: MainViewModel by viewModels()

    /**
     * onCreate callback method of the Activity
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retailer.printRetailerDetails()
        getAlbums()
    }

    private fun getAlbums() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.albumState.collectLatest { state ->
                    when (state) {
                        is AlbumResponseState.Loading -> {
                            with(binding) {
                                progressBar.visibility = View.VISIBLE
                                rvAlbums.visibility = View.GONE
                            }
                        }

                        is AlbumResponseState.Success -> {
                            with(binding) {
                                progressBar.visibility = View.GONE
                                rvAlbums.visibility = View.VISIBLE
                            }
                            albums = state.albums.toMutableList()
                            adapter = AlbumAdapter(albums)
                            binding.rvAlbums.adapter = adapter
                        }

                        is AlbumResponseState.Failed -> {
                            with(binding) {
                                progressBar.visibility = View.GONE
                                rvAlbums.visibility = View.GONE
                            }
                            Toast.makeText(
                                this@MainActivity,
                                state.error.message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
        handler.postDelayed({
            albums.add(Album(101, 10245, "Taylor Swift Red"))
            adapter.setAlbums(albums)
            adapter.notifyItemInserted(albums.size - 1)
        }, 60 * 60 * 100 * 2)
    }
}
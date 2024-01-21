package com.example.dagger_hilt_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger_hilt_android.adapter.AlbumAdapter
import com.example.dagger_hilt_android.databinding.ActivityMainBinding
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
                            binding.rvAlbums.adapter = AlbumAdapter(state.albums)
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
    }
}
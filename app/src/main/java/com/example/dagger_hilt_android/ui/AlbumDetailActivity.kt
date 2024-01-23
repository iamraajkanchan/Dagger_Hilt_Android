package com.example.dagger_hilt_android.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dagger_hilt_android.databinding.ActivityAlbumDetailBinding
import com.example.dagger_hilt_android.model.Album

class AlbumDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlbumDetailBinding
    private var album: Album? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        if (intent.hasExtra(ALBUM_DETAIL_EXTRA)) {
            album = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra(ALBUM_DETAIL_EXTRA, Album::class.java)
            } else {
                intent.getParcelableExtra(ALBUM_DETAIL_EXTRA)
            }
        }
        binding.tvAlbumTitle.text = album?.title
        binding.tvAlbumUserId.text = "${album?.userId ?: 0}"
    }

    companion object {
        const val ALBUM_DETAIL_EXTRA = "album details"
    }
}

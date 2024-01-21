package com.example.dagger_hilt_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger_hilt_android.databinding.RecyclerItemAlbumBinding
import com.example.dagger_hilt_android.model.Album

class AlbumAdapter(private val albums: List<Album>) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding =
            RecyclerItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) =
        holder.bind(albums[position])

    override fun getItemCount(): Int = albums.size

    class AlbumViewHolder(private val binding: RecyclerItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            binding.tvAlbumId.text = "${album.id}"
            binding.tvAlbumTitle.text = album.title
        }
    }
}
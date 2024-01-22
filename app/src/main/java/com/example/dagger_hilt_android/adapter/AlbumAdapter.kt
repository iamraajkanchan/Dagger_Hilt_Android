package com.example.dagger_hilt_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger_hilt_android.databinding.RecyclerItemAlbumBinding
import com.example.dagger_hilt_android.model.Album

class AlbumAdapter(private val albums: MutableList<Album>) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>(), AutoUpdatableAdapter {

    /*
    val albums: List<Album> by Delegates.observable(emptyList()) { _, oldValue, newValue ->
        autoNotify(oldValue, newValue) { old, new -> old.id == new.id }
    }
    */

    fun updateAlbums(newAlbums: List<Album>) {
        val diffResult = DiffUtil.calculateDiff(AlbumCallback(albums, newAlbums))
        albums.clear()
        albums.addAll(newAlbums)
        diffResult.dispatchUpdatesTo(this)
    }

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

    class AlbumCallback(private val oldAlbums: List<Album>, private val newAlbums: List<Album>) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldAlbums.size

        override fun getNewListSize(): Int = newAlbums.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldAlbums[oldItemPosition].id == newAlbums[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val (oldId, oldUserId, oldTitle) = oldAlbums[oldItemPosition]
            val (newId, newUserId, newTitle) = newAlbums[newItemPosition]
            return oldId == newId && oldUserId == newUserId && oldTitle == newTitle
        }

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return super.getChangePayload(oldItemPosition, newItemPosition)
        }
    }

}
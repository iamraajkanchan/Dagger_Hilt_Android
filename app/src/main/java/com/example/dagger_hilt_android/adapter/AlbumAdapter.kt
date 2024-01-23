package com.example.dagger_hilt_android.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger_hilt_android.databinding.RecyclerItemAlbumBinding
import com.example.dagger_hilt_android.model.Album
import com.example.dagger_hilt_android.ui.AlbumDetailActivity

class AlbumAdapter(private val albums: MutableList<Album>? = null) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>(), AutoUpdatableAdapter {

    /*
    val albums: List<Album> by Delegates.observable(emptyList()) { _, oldValue, newValue ->
        autoNotify(oldValue, newValue) { old, new -> old.id == new.id }
    }
    */
    var context: Context? = null
    fun setAlbums(newAlbums: List<Album>) {
        val diffResult = DiffUtil.calculateDiff(AlbumCallback(albums ?: emptyList(), newAlbums))
        albums?.clear()
        albums?.addAll(newAlbums)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding =
            RecyclerItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        context?.let { holder.bind(it, albums?.get(position)) }
    }

    override fun getItemCount(): Int = albums?.size ?: 0

    class AlbumViewHolder(private val binding: RecyclerItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, album: Album?) {
            binding.tvAlbumId.text = "${album?.id}"
            binding.tvAlbumTitle.text = album?.title
            binding.cvAlbumIdContainer.setOnClickListener {
                Intent(context, AlbumDetailActivity::class.java).apply {
                    putExtra(AlbumDetailActivity.ALBUM_DETAIL_EXTRA, album)
                    context.startActivity(this)
                }
            }
        }
    }

    // AlbumCallback is used when you are trying to manipulate the list of albums
    // eg: addition, removal, sorting etc
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
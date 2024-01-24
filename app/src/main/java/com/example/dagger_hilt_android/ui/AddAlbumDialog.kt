package com.example.dagger_hilt_android.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast

import com.example.dagger_hilt_android.databinding.DialogAddAlbumBinding
import com.example.dagger_hilt_android.model.Album
import com.example.dagger_hilt_android.viewModel.MainViewModel

class AddAlbumDialog(private val context: Context, private val viewModel: MainViewModel) :
    Dialog(context) {
    private lateinit var binding: DialogAddAlbumBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddAlbumBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)
        binding.btnAddAlbum.setOnClickListener {
            val id = binding.edtAlbumId.text.trim().toString()
            val userId = binding.edtAlbumUserId.text.trim().toString()
            val title = binding.edtAlbumTitle.text.trim().toString()
            if (isValidInput(id, userId, title)) {
                viewModel.addAlbum(Album(Integer.parseInt(id), Integer.parseInt(userId), title))
                dismiss()
            } else {
                Toast.makeText(context, "Please enter a valid input for Album", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun isValidInput(id: String, userId: String, title: String): Boolean {
        return id.isNotEmpty() && id.isNotBlank() && userId.isNotEmpty() && userId.isNotBlank() && title.isNotEmpty() && title.isNotBlank()
    }
}
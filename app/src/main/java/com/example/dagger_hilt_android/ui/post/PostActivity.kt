package com.example.dagger_hilt_android.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.dagger_hilt_android.R
import com.example.dagger_hilt_android.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : AppCompatActivity()
{
    private val postViewModel : PostViewModel by viewModels()
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        postViewModel.getPostLiveData().observe(this) {
            Log.d(Utils.TAG , "PostActivity :: onCreate :: Posts :: $it")
        }

        postViewModel.getPost()
    }
}
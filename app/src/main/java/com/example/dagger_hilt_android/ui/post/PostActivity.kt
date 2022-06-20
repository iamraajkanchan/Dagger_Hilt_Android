package com.example.dagger_hilt_android.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.dagger_hilt_android.R
import com.example.dagger_hilt_android.model.Post
import com.example.dagger_hilt_android.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : AppCompatActivity()
{
    private val viewModel : PostViewModel by viewModels()
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        viewModel.insertAll(Post(0 , "Dagger-Hilt" , "Learn Dagger Hilt") ,
            Post(0 , "Java" , "Learn Java") ,
            Post(0 , "Android" , "Learn Android") ,
            Post(0 , "Kotlin" , "Learn Kotlin"))

        viewModel.postLiveData.observe(this) {
            Log.d(Utils.TAG , "PostActivity :: onCreate :: $it")
        }
    }
}
package com.example.dagger_hilt_android.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.dagger_hilt_android.BuildConfig
import com.example.dagger_hilt_android.R
import com.example.dagger_hilt_android.databinding.ActivityPostBinding
import com.example.dagger_hilt_android.model.Post
import com.example.dagger_hilt_android.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * PostActivity is the Main and Launcher of the application.
 * */
@AndroidEntryPoint
class PostActivity : AppCompatActivity()
{
    private val viewModel : PostViewModel by viewModels()
    private var _binding : ActivityPostBinding? = null
    private val binding get() = _binding

    /**
     * onCreate callback method of the Activity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        _binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel.insertAll(Post(0 , "Dagger-Hilt" , "Learn Dagger Hilt") ,
            Post(0 , "Java" , "Learn Java") ,
            Post(0 , "Android" , "Learn Android") ,
            Post(0 , "Kotlin" , "Learn Kotlin"))

        viewModel.postLiveData.observe(this) {
            if (BuildConfig.DEBUG) Log.d(Utils.TAG , "PostActivity :: onCreate :: $it")
        }
    }
}
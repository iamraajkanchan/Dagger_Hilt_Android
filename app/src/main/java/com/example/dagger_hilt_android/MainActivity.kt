package com.example.dagger_hilt_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.dagger_hilt_android.fragment.MainFragment
import com.example.dagger_hilt_android.model.*
import com.example.dagger_hilt_android.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// Processor : Application
// Camera : Fragment
// Battery : Activity

@AndroidEntryPoint
class MainActivity : AppCompatActivity()
{

    @Inject
    lateinit var battery1 : Battery

    @Inject
    lateinit var battery2 : Battery

    @Inject
    lateinit var processor1 : Processor

    @Inject
    lateinit var processor2 : Processor

    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(Utils.TAG , "===============MainActivity==================")
        Log.d(Utils.TAG , "Battery 1: $battery1")
        Log.d(Utils.TAG , "Battery 2: $battery2")
        Log.d(Utils.TAG , "Processor 1: $processor1")
        Log.d(Utils.TAG , "Processor 2: $processor2")
        val mainFragment = MainFragment()
        replaceFragment(mainFragment)
    }

    private fun replaceFragment(fragment : Fragment)
    {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameContainer , fragment , "MainFragment")
            commit()
        }
    }
}
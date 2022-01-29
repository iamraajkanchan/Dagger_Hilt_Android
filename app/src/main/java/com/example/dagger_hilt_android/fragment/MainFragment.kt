package com.example.dagger_hilt_android.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dagger_hilt_android.R
import com.example.dagger_hilt_android.model.*
import com.example.dagger_hilt_android.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment()
{

    @Inject
    lateinit var camera1 : Camera

    @Inject
    lateinit var camera2 : Camera

    @Inject
    lateinit var battery1 : Battery

    @Inject
    lateinit var battery2 : Battery

    @Inject
    lateinit var processor1 : Processor

    @Inject
    lateinit var processor2 : Processor

    private lateinit var mView : View;

    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?
    ) : View?
    { // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_main , container , false)
        Log.d(Utils.TAG , "===============MainFragment==================")
        Log.d(Utils.TAG , "Camera 1: $camera1")
        Log.d(Utils.TAG , "Camera 2: $camera2")
        Log.d(Utils.TAG , "Battery 1: $battery1")
        Log.d(Utils.TAG , "Battery 2: $battery2")
        Log.d(Utils.TAG , "Processor 1: $processor1")
        Log.d(Utils.TAG , "Processor 2: $processor2")
        return mView
    }

    override fun onAttach(context : Context)
    {
        super.onAttach(context)
    }

    override fun onViewCreated(view : View , savedInstanceState : Bundle?)
    {
        super.onViewCreated(view , savedInstanceState)
    }

    override fun onStart()
    {
        super.onStart()
    }

    override fun onResume()
    {
        super.onResume()
    }

}
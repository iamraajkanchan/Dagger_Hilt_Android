package com.example.dagger_hilt_android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * First you have to extend the [Application] class and then add it into Manifest file as
 * [android:name=".MainApplication"]
 * Second you have to annotate the class with [HiltAndroidApp]
 * */
@HiltAndroidApp
class MainApplication : Application() {
}
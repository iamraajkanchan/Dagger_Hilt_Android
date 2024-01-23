package com.example.dagger_hilt_android.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.dagger_hilt_android.R
import com.example.dagger_hilt_android.adapter.AlbumAdapter
import org.junit.Assert.*

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// Reference
// https://github.com/android/testing-samples/blob/main/ui/espresso/RecyclerViewSample/app/src/androidTest/java/com/example/android/testing/espresso/RecyclerViewSample/RecyclerViewSampleTest.java

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun albumRecyclerViewHasAParticularAlbum() {
        onView(withId(R.id.rvAlbums)).perform(
            RecyclerViewActions.scrollTo<AlbumAdapter.AlbumViewHolder>(
                hasDescendant(withText("omnis laborum odio"))
            )
        )
    }

    @Test
    fun recycler_view_navigates_to_particular_album_after_click() {
        onView(withId(R.id.rvAlbums)).perform(
            RecyclerViewActions.actionOnItemAtPosition<AlbumAdapter.AlbumViewHolder>(3, click())
        )
        onView(withId(R.id.tvAlbumTitle)).check(matches(withText("omnis laborum odio")))
    }
}
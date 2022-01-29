package com.example.dagger_hilt_android.model

data class Posts(
	val post: List<PostItem?>? = null
)

data class PostItem(
	val id: Int? = null,
	val title: String? = null,
	val body: String? = null,
	val userId: Int? = null
)


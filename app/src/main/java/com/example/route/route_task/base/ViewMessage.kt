package com.example.route.route_task.base


data class ViewMessage(
    val title : String? = null,
    val message: String? = null,
    val posActionName: String? = null,
    val posAction: (() -> Unit)? = null,
    val negActionName: String? = null,
    val negAction: (() -> Unit)? = null,
    val isDismissible: Boolean = true,
)

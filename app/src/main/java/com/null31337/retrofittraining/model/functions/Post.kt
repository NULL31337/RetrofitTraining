package com.null31337.retrofittraining.model.functions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    @SerialName("userId")
    val userId: Int = -1,
    @SerialName("id")
    val id: Int = -1,
    @SerialName("title")
    val title: String = "Pepega",
    @SerialName("body")
    val body: String = "42",
)
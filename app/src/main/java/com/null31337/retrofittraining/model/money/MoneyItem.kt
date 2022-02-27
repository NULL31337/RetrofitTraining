package com.null31337.retrofittraining.model.money

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MoneyItem(
    @SerialName("Value")
    val current: Double,
    @SerialName("Name")
    val name: String,
    @SerialName("Previous")
    val previous: Double
)

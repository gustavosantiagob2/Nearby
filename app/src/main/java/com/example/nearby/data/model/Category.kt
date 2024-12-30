package com.example.nearby.data.model

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: String,
    val name: String,
){
    @get:DrawableRes
    val icon: Int?
        get() = NearbyCategoryFilterChipView.fromDescription(description = name)?.icon
}
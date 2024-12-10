package com.example.nearby.data.model

import androidx.annotation.DrawableRes
import com.example.nearby.ui.component.category.NearbyCategoryFilterChip

data class NearbyCategory(
    val id: String,
    val name: String,
){
    @get:DrawableRes
    val icon: Int?
        get() = NearbyCategoryFilterChipView.fromDescription(description = name)?.icon
}

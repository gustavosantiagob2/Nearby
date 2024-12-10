package com.example.nearby.data.model

import androidx.annotation.DrawableRes
import com.example.nearby.R

enum class NearbyCategoryFilterChipView(
    val description: String,
    @DrawableRes val icon: Int
) {
    ALIMENTACAO("Alimentação", icon = R.drawable.ic_tools_kitchen_2),
    COMPRAS("Alimentação", icon = R.drawable.ic_shopping_bag),
    HOSPEDAGEM("Alimentação", icon = R.drawable.ic_bed),
    SUPERMERCADO("Alimentação", icon = R.drawable.ic_shopping_cart),
    ENTRETENIMENTO("Alimentação", icon = R.drawable.ic_movie),
    FARMACIA("Alimentação", icon = R.drawable.ic_first_aid_kit),
    COMBUSTIVEL("Alimentação", icon = R.drawable.ic_gas_station),
    PADARIA("Alimentação", icon = R.drawable.ic_bakery);

    companion object {
        fun fromDescription(description: String): NearbyCategoryFilterChipView? {
            return entries.find { it.description == description }
        }
    }

}
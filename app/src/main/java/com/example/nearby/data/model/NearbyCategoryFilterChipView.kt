package com.example.nearby.data.model

import androidx.annotation.DrawableRes
import com.example.nearby.R

enum class NearbyCategoryFilterChipView(
    val description: String,
    @DrawableRes val icon: Int
) {
    ALIMENTACAO("Alimentação", icon = R.drawable.ic_tools_kitchen_2),
    COMPRAS("Compras", icon = R.drawable.ic_shopping_bag),
    HOSPEDAGEM("Hospedagem", icon = R.drawable.ic_bed),
    SUPERMERCADO("Supermercado", icon = R.drawable.ic_shopping_cart),
    ENTRETENIMENTO("Entretenimento", icon = R.drawable.ic_movie),
    FARMACIA("Farmacia", icon = R.drawable.ic_first_aid_kit),
    COMBUSTIVEL("Combustivel", icon = R.drawable.ic_gas_station),
    CINEMA("Cinema", icon = R.drawable.ic_movie),
    PADARIA("Padaria", icon = R.drawable.ic_bakery);

    companion object {
        fun fromDescription(description: String): NearbyCategoryFilterChipView? {
            return entries.find { it.description == description }
        }
    }

}
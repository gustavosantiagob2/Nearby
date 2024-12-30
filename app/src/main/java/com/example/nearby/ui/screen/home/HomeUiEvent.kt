package com.example.nearby.ui.screen.home

sealed class HomeUiEvent {
    data object OnFetchCategories : HomeUiEvent()
    data class OnFetchMarkets(val categoryID: String) : HomeUiEvent()
}
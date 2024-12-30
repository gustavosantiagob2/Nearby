package com.example.nearby.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.network.NearbyRemoteDataSource
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            is HomeUiEvent.OnFetchCategories -> fetchCategories()
            is HomeUiEvent.OnFetchMarkets -> fetchMarkets(event.categoryID)
        }
    }


    private fun fetchCategories() {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                NearbyRemoteDataSource.getCategories().fold(
                    onSuccess = { categories ->
                        currentUiState.copy(
                            categories = categories
                        )
                    },
                    onFailure = { _ ->
                        currentUiState.copy(
                            categories = emptyList()
                        )
                    }
                )
            }
        }
    }

    private fun fetchMarkets(categoryId: String) {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                NearbyRemoteDataSource.getMarkets(categoryId).fold(
                    onSuccess = { markets ->
                        currentUiState.copy(
                            markets = markets,
                            marketLocations = markets.map { market ->
                                LatLng(market.latitude, market.longitude)
                            }
                        )
                    },
                    onFailure = { _ ->
                        currentUiState.copy(
                            markets = emptyList(),
                            marketLocations = emptyList()
                        )
                    }
                )
            }
        }
    }


}
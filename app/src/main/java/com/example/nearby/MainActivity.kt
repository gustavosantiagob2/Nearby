package com.example.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.nearby.data.model.Market
import com.example.nearby.ui.route.Home
import com.example.nearby.ui.route.QrCodeScanner
import com.example.nearby.ui.route.Splash
import com.example.nearby.ui.route.Welcome
import com.example.nearby.ui.screen.home.HomeScreen
import com.example.nearby.ui.screen.home.HomeViewModel
import com.example.nearby.ui.screen.market_details.MarketDetailsScreen
import com.example.nearby.ui.screen.market_details.MarketDetailsUiEvent
import com.example.nearby.ui.screen.market_details.MarketDetailsViewModel
import com.example.nearby.ui.screen.qrcode_scanner.QrCodeScannerScreen
import com.example.nearby.ui.screen.splash.SplashScreen
import com.example.nearby.ui.screen.welcome.WelcomeScreen
import com.example.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()

                val homeViewModel by viewModels<HomeViewModel>()
                val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()

                val marketDetailsViewModel by viewModels<MarketDetailsViewModel>()
                val marketDetailsUiState by marketDetailsViewModel.uiState.collectAsStateWithLifecycle()

                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            modifier = Modifier.fillMaxSize(),
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }
                    composable<Welcome> {
                        WelcomeScreen(
                            onNavigateToHome = {
                                navController.navigate(Home)
                            }
                        )
                    }
                    composable<Home> {
                        HomeScreen(
                            onNavigateToMarketDetails = { selectedMarket ->
                                navController.navigate(selectedMarket)
                            },
                            uiState = homeUiState,
                            onEvent = homeViewModel::onEvent
                        )
                    }
                    composable<Market> {
                        val selectedMarket = it.toRoute<Market>()

                        MarketDetailsScreen(
                            market = selectedMarket,
                            uiState = marketDetailsUiState,
                            onEvent = marketDetailsViewModel::onEvent,
                            onNavigateBack = {
                                navController.popBackStack()
                            },
                            onNavigateToQrCodeScanner = {
                                navController.navigate(QrCodeScanner)
                            }
                        )
                    }
                    //Link para os QRCodes válidos
                    //https://docs-rocketseat.notion.site/QRCODE-V-LIDOS-954f091130c8468690a861be9066b902
                    composable<QrCodeScanner> {
                        QrCodeScannerScreen(
                            onCompletedScan = { qrCodeContent ->
                                if (qrCodeContent.isNotEmpty())
                                    marketDetailsViewModel.onEvent(
                                        MarketDetailsUiEvent.OnFetchCoupon(
                                            qrCodeContent
                                        )
                                    )

                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}

package com.example.nearby.ui.component.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nearby.R


@Composable
fun WelcomeContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(text = "Veja como funciona:", style = typography.bodyLarge)
        WelcomeHowItWorks(
            Modifier.fillMaxSize(),
            "Encontre seus estabelecimentos",
            "Veja locais perto de você que são parceiros Nearby",
            R.drawable.ic_map_pin
        )
        WelcomeHowItWorks(
            Modifier.fillMaxSize(),
            "Ative o cupom com Qr Code",
            "Escaneie o código no estabelecimento para usar o benefício",
            R.drawable.ic_qrcode
        )
        WelcomeHowItWorks(
            Modifier.fillMaxSize(),
            "Garanta vantagens perto de você",
            "Ative cupons onde estiver, em diferentes tipos de estabelecimentos",
            R.drawable.ic_ticket
        )
    }
}

package com.example.nearby.ui.component.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nearby.R

@Composable
fun WelcomeHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img_logo_logo_icon),
            contentDescription = "Nearby app logo "
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Boas vindas ao Nearby",
            style = typography.headlineLarge
        )
        Text(
            text = "Tenha cupons de vantagem para usar em seus estabelecimentos favoritos",
            style = typography.bodyLarge
        )
    }
}

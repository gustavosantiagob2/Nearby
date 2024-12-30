package com.example.nearby.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nearby.data.model.Rule
import com.example.nearby.data.model.mock.MockRules
import com.example.nearby.ui.theme.Gray400
import com.example.nearby.ui.theme.Gray500

@Composable
fun NearbyMarketDetailsRules(modifier: Modifier = Modifier, rules: List<Rule>) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Regulamento", style = MaterialTheme.typography.headlineSmall, color = Gray400)

        Text(
            modifier = Modifier .padding(start = 16.dp),
            text = rules.joinToString(separator = "\n", transform = {"• ${it.description}"}),
            style = MaterialTheme.typography.labelSmall,
            color = Gray500,
            lineHeight = 24.sp
        )
    }
}

@Preview
@Composable
private fun NearbyMarketDetailsRulesPreview() {
    NearbyMarketDetailsRules(
        modifier = Modifier.fillMaxWidth(),
        rules = MockRules
    )
}
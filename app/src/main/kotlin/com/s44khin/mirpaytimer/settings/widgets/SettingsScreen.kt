package com.s44khin.mirpaytimer.settings.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ScalingLazyColumn
import com.s44khin.mirpaytimer.common.Card

@Composable
fun SettingsScreen(
    timerTicks: Int,
    card: Card,
    onChangeTimer: (Int) -> Unit,
    onChangeCard: (Card) -> Unit
) {
    ScalingLazyColumn(modifier = Modifier.fillMaxSize()) {
        settingsTitle()

        spacer(8.dp)

        timerBlock(
            currentTicks = timerTicks,
            onChangeTimer = onChangeTimer,
        )

        cardBlock(
            currentCard = card,
            onChangeCard = onChangeCard
        )
    }
}

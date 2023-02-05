package com.s44khin.mirpaytimer.main.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.s44khin.mirpaytimer.R
import com.s44khin.mirpaytimer.common.Card
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun MirPayScreen(
    maxTicks: Int,
    card: Card,
    onTimerEnd: () -> Unit,
) {
    var currentTicks by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (currentTicks != maxTicks) {
            delay(1.seconds)
            currentTicks++

            if (currentTicks == maxTicks) {
                onTimerEnd()
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(R.drawable.ic_wallet),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(2.dp))

            Text(
                text = stringResource(R.string.mir),
                fontWeight = FontWeight.Bold
            )

            Text(text = stringResource(R.string.pay))
        }

        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .height(72.dp)
                .align(Alignment.Center),
            painter = painterResource(card.imageId),
            contentDescription = null
        )

        AnimatedCounter(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            count = (maxTicks - currentTicks)
        )
    }
}

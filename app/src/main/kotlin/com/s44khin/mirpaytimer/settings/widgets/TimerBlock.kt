package com.s44khin.mirpaytimer.settings.widgets

import android.app.RemoteInput
import android.view.inputmethod.EditorInfo
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ScalingLazyListScope
import androidx.wear.compose.material.Text
import androidx.wear.input.RemoteInputIntentHelper
import androidx.wear.input.wearableExtender
import com.s44khin.mirpaytimer.R
import com.s44khin.mirpaytimer.common.DEFAULT_TIMER

private const val TIMER_KEY = "timer"
private val DEFAULT_VALUES = arrayOf("5", "10", "15", "20", "25", "30")

fun ScalingLazyListScope.timerBlock(
    currentTicks: Int,
    onChangeTimer: (Int) -> Unit,
) = item {
    var newTimer by remember { mutableStateOf(currentTicks) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        it.data?.let { data ->
            val results = RemoteInput.getResultsFromIntent(data)
            newTimer = (results.getString(TIMER_KEY) ?: DEFAULT_TIMER.toString()).toInt()
            onChangeTimer(newTimer)
        }
    }

    val label = stringResource(R.string.settings_enter_ms)

    DefaultBox(onClick = { launcher.launch(createIntent(label)) }) {
        Column {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                text = stringResource(R.string.settings_timer_title),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp),
                text = newTimer.toString(),
                fontSize = 10.sp,
            )
        }
    }
}

private fun createIntent(label: String) = RemoteInputIntentHelper.putRemoteInputsExtra(
    intent = RemoteInputIntentHelper.createActionRemoteInputIntent(),
    remoteInputs = listOf(
        RemoteInput
            .Builder(TIMER_KEY)
            .setLabel(label)
            .setAllowFreeFormInput(false)
            .setChoices(DEFAULT_VALUES)
            .wearableExtender {
                setEmojisAllowed(false)
                setInputActionType(EditorInfo.IME_ACTION_DONE)
            }
            .build()
    )
)

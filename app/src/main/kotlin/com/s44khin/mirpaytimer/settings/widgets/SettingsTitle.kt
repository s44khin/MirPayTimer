package com.s44khin.mirpaytimer.settings.widgets

import androidx.compose.ui.res.stringResource
import androidx.wear.compose.material.ScalingLazyListScope
import androidx.wear.compose.material.Text
import com.s44khin.mirpaytimer.R

fun ScalingLazyListScope.settingsTitle() = item {
    Text(text = stringResource(R.string.settings_title))
}

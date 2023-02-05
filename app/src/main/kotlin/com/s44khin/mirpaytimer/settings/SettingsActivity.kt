package com.s44khin.mirpaytimer.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.s44khin.mirpaytimer.common.AppStorage
import com.s44khin.mirpaytimer.common.PREFS_NAME
import com.s44khin.mirpaytimer.settings.widgets.SettingsScreen

class SettingsActivity : ComponentActivity() {

    private val appStorage by lazy {
        AppStorage(sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SettingsScreen(
                timerTicks = appStorage.timerTicks,
                card = appStorage.card,
                onChangeTimer = { appStorage.timerTicks = it },
                onChangeCard = { appStorage.card = it }
            )
        }
    }
}

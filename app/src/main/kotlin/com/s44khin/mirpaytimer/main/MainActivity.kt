package com.s44khin.mirpaytimer.main

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.s44khin.mirpaytimer.common.AppStorage
import com.s44khin.mirpaytimer.common.PREFS_NAME
import com.s44khin.mirpaytimer.main.widgets.MirPayScreen

class MainActivity : ComponentActivity() {

    private val appStorage by lazy {
        AppStorage(sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        setContent {
            MirPayScreen(
                maxTicks = appStorage.timerTicks,
                card = appStorage.card,
                onTimerEnd = { finish() }
            )
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    override fun onStop() {
        super.onStop()
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}

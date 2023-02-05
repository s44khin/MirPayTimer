package com.s44khin.mirpaytimer.main

import android.app.PendingIntent
import android.content.Intent
import android.graphics.drawable.Icon
import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.MonochromaticImage
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.data.ShortTextComplicationData
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService
import com.s44khin.mirpaytimer.R

class MainComplicationService : SuspendingComplicationDataSourceService() {

    override fun getPreviewData(type: ComplicationType): ComplicationData? {
        if (type != ComplicationType.SHORT_TEXT) {
            return null
        }

        return shortData()
    }

    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData {
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(applicationContext, MainActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE
        )

        return shortData(pendingIntent)
    }

    private fun shortData(tapAction: PendingIntent? = null): ShortTextComplicationData {
        return ShortTextComplicationData.Builder(
            text = PlainComplicationText.Builder(getText(R.string.pay)).build(),
            contentDescription = PlainComplicationText.Builder(getText(R.string.mir_pay)).build()
        )
            .setMonochromaticImage(getPayIcon())
            .setTapAction(tapAction)
            .build()
    }

    private fun getPayIcon(): MonochromaticImage {
        return MonochromaticImage.Builder(
            image = Icon.createWithResource(
                applicationContext,
                R.drawable.ic_wallet
            )
        ).build()
    }
}

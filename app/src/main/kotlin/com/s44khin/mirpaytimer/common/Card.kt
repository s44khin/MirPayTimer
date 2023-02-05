package com.s44khin.mirpaytimer.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.s44khin.mirpaytimer.R

enum class Card(
    @StringRes val titleId: Int,
    @DrawableRes val imageId: Int
) {

    ALPHA(
        titleId = R.string.card_alpha_title,
        imageId = R.drawable.card_alpha_image,
    ),

    MTS(
        titleId = R.string.card_mts_title,
        imageId = R.drawable.card_mts_image,
    ),

    OPEN(
        titleId = R.string.card_open_title,
        imageId = R.drawable.card_open_image,
    ),

    ROSBANK(
        titleId = R.string.card_rosbank_title,
        imageId = R.drawable.card_rosbank_image,
    ),

    SBER(
        titleId = R.string.card_sber_title,
        imageId = R.drawable.card_sber_image,
    ),

    TINKOFF(
        titleId = R.string.card_tinkoff_title,
        imageId = R.drawable.card_tinkoff_image
    ),

    URALSIB(
        titleId = R.string.card_uralsib_title,
        imageId = R.drawable.card_uralsib_image,
    ),

    VTB(
        titleId = R.string.card_vtb_title,
        imageId = R.drawable.card_vtb_image,
    )
}

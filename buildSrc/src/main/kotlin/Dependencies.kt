object Dependencies {

    const val CORE_KTX_VERSION = "1.9.0"
    const val PLAY_SERVICES_VERSION = "18.0.0"
    const val APP_COMPAT_VERSION = "1.6.0"

    const val CORE_KTX = "androidx.core:core-ktx:$CORE_KTX_VERSION"
    const val PLAY_SERVICES = "com.google.android.gms:play-services-wearable:$PLAY_SERVICES_VERSION"
    const val APP_COMPAT = "androidx.appcompat:appcompat:$APP_COMPAT_VERSION"

    object Compose {

        const val ACTIVITY_VERSION = "1.6.1"
        const val COMPILER_VERSION = "1.4.0"
        const val FOUNDATION_VERSION = "1.1.1"
        const val MATERIAL_VERSION = "1.1.1"
        const val UI_VERSION = "1.3.3"

        const val ACITIVTY = "androidx.activity:activity-compose:$ACTIVITY_VERSION"
        const val FOUNDATION = "androidx.wear.compose:compose-foundation:$FOUNDATION_VERSION"
        const val MATERIAL = "androidx.wear.compose:compose-material:$MATERIAL_VERSION"
        const val UI = "androidx.compose.ui:ui:$UI_VERSION"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling-preview:$UI_VERSION"
    }

    object Wear {

        const val COMPLICATIONS_VERSION = "1.1.1"
        const val INPUT_VERSION = "1.2.0-alpha02"

        const val COMPLICATIONS =
            "androidx.wear.watchface:watchface-complications-data-source-ktx:$COMPLICATIONS_VERSION"

        const val INPUT = "androidx.wear:wear-input:$INPUT_VERSION"
    }
}

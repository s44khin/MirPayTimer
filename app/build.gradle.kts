plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
}

android {
    namespace = "com.s44khin.mirpaytimer"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "com.s44khin.mirpaytimer"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }

        debug {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.COMPILER_VERSION
    }
}

dependencies {

    // Core
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.PLAY_SERVICES)
    implementation(Dependencies.APP_COMPAT)

    // Compose
    implementation(Dependencies.Compose.ACITIVTY)
    implementation(Dependencies.Compose.FOUNDATION)
    implementation(Dependencies.Compose.MATERIAL)
    implementation(Dependencies.Compose.UI)
    implementation(Dependencies.Compose.UI_TOOLING)

    // Wear
    implementation(Dependencies.Wear.COMPLICATIONS)
    implementation(Dependencies.Wear.INPUT)
}

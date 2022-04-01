plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
}

android {
    defaultConfig {
        minSdk = AppMetaData.minSdk
        targetSdk = AppMetaData.targetSdk
        compileSdk = AppMetaData.compileSdk

        testInstrumentationRunner = AppMetaData.testInstrumentationRunner
        consumerProguardFiles(AppMetaData.consumerRules)
    }

    buildTypes {
        release {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles(AppMetaData.proguardAndroidOptimize, AppMetaData.proguardRules)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AppMetaData.jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Libraries.kotlin)

    implementation(Libraries.appCompat)
}
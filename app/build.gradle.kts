plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
}

android {

    defaultConfig {
        applicationId = AppMetaData.applicationId
        minSdk = AppMetaData.minSdk
        targetSdk = AppMetaData.targetSdk
        compileSdk = AppMetaData.compileSdk
        versionCode = AppMetaData.versionCode
        versionName = AppMetaData.versionName

        testInstrumentationRunner = AppMetaData.testInstrumentationRunner
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
}

dependencies {
    implementation(Libraries.kotlin)
    implementation(project(Modules.di))

    implementation(Libraries.coreKtx)
    implementation(Libraries.appCompat)
    implementation(Libraries.androidMaterial)
    implementation(Libraries.constraintLayout)

    androidTestImplementation(Libraries.androidEspressoCore)
}
plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
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
}

dependencies {
    implementation(Libraries.kotlin)
    implementation(Libraries.koin)
    implementation(Libraries.koinAndroid)

    implementation(project(Modules.database_api))
    implementation(project(Modules.database_impl))
    implementation(project(Modules.feature_study_api))
    implementation(project(Modules.feature_study_impl))
}
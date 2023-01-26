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
    implementation(project(Modules.feature_study_api))
    implementation(project(Modules.database_api))
    implementation(project(Modules.datastore_api))

    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.googleMaterial)
    implementation(Libraries.koin)
    implementation(Libraries.koinAndroid)

    implementation(Libraries.stetho)
    implementation(Libraries.lifecycleViewModel)
    implementation(Libraries.lifecycleRuntime)

    testImplementation(Libraries.jUnit)
    androidTestImplementation(Libraries.androidTestRunner)
    androidTestImplementation(Libraries.androidEspressoCore)
}
object Versions {
    const val kotlin = "1.6.10"
    const val appCompat = "1.4.1"
    const val coreKtx = "1.7.0"
    const val androidMaterial = "1.5.0"
    const val constraintLayout = "2.1.3"
    const val googleMaterial = "1.5.0"

    const val koin = "3.1.5"
    const val room = "2.4.2"

    const val lifecycle = "2.2.0"

    const val stetho = "1.5.1"

    const val jUnit = "4.+"
    const val androidTestRunner = "1.0.2"
    const val androidEspressoCore = "3.4.0"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"

    const val koin = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"

    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // Room
    const val roomCommon = "androidx.room:room-common:${Versions.room}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"

    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val androidTestRunner = "com.android.support.test:runner:${Versions.androidTestRunner}"
    const val androidEspressoCore =
        "androidx.test.espresso:espresso-core:${Versions.androidEspressoCore}"
}

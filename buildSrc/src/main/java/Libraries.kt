object Versions {
    const val appCompat = "1.4.1"
    const val coreKtx = "1.7.0"
    const val androidMaterial = "1.5.0"

    const val jUnit = "4.+"
    const val androidTestRunner = "1.0.2"
    const val androidEspressoCore = "3.4.0"
}

object Libraries {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"

    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val androidTestRunner = "com.android.support.test:runner:${Versions.androidTestRunner}"
    const val androidEspressoCore =
        "androidx.test.espresso:espresso-core:${Versions.androidEspressoCore}"
}

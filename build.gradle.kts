// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildScript.gradle)
        classpath(BuildScript.kotlin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
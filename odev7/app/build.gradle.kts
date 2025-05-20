plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'
}

android {
    namespace 'com.example.todoapp'
    compileSdk 34

    defaultConfig {
        applicationId "com.example.todoapp"
        minSdk 24
        targetSdk 34
        versionCode 1
        versionName "1.0"
    }

    buildFeatures {
        compose true
    }

    composeOptions {
        kotlinCompilerExtensionVersion '1.5.3'
    }

    kotlinOptions {
        jvmTarget = '1.8'
    }
}

dependencies {
    implementation 'androidx.core:core-ktx:1.12.0'
    implementation 'androidx.activity:activity-compose:1.8.0'
    implementation 'androidx.compose.ui:ui:1.5.0'
    implementation 'androidx.compose.material:material:1.5.0'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2'

    implementation "androidx.room:room-runtime:2.6.1"
    kapt "androidx.room:room-compiler:2.6.1"
    implementation "androidx.room:room-ktx:2.6.1"

    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-compiler:$hilt_version"
    implementation "androidx.hilt:hilt-navigation-compose:1.1.0"
}

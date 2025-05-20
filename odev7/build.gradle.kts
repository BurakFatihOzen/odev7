buildscript {
    ext.hilt_version = '2.48'
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:8.1.0'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0"
        classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

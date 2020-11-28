package config

object BuildPlugins {
    const val ANDROID_PLUGIN = "com.android.tools.build:gradle:${Versioning.ANDROID_GRADLE_PLUGIN_VERSION}"
    const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versioning.KOTLIN_VERSION}"
    const val NAVIGATION_SAFE_ARGS_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versioning.NAVIGATION_VERSION}"
    const val JACOCO_PLUGIN = "org.jacoco:org.jacoco.core:${Versioning.JACOCO_VERSION}"
}
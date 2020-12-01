package config

import org.gradle.api.artifacts.dsl.DependencyHandler

object Libs {
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.2.0"
    const val CORE_KTX = "androidx.core:core-ktx:1.3.2"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.0.2"
    const val LEGACY_SUPPORT_V4 = "androidx.legacy:legacy-support-v4:1.0.0"
    const val MULTIDEX = "androidx.multidex:multidex:2.0.1"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:1.1.0"
    const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versioning.ANDROIDX_FRAGMENT_VERSION}"
    const val BIOMETRIC = "androidx.biometric:biometric:1.0.0"

    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versioning.LIFECYCLE_VERSION}"
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versioning.LIFECYCLE_VERSION}"
    const val LIFECYCLE_COMMON_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:${Versioning.LIFECYCLE_VERSION}"

    const val NAVIGATION_FRAGMENT_KTX ="androidx.navigation:navigation-fragment-ktx:${Versioning.NAVIGATION_VERSION}"
    const val NAVIGATION_UI_KTX =  "androidx.navigation:navigation-ui-ktx:${Versioning.NAVIGATION_VERSION}"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versioning.ROOM_VERSION}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versioning.ROOM_VERSION}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versioning.ROOM_VERSION}"

    const val MATERIAL_DESIGN = "com.google.android.material:material:1.2.1"

    const val KOTLIN_JAVA8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versioning.KOTLIN_VERSION}"
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${Versioning.KOTLIN_VERSION}"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versioning.COROUTINES_VERSION}"

    const val KOIN_CORE = "org.koin:koin-core:${Versioning.KOIN_VERSION}"
    const val KOIN_VIEW_MODEL = "org.koin:koin-androidx-viewmodel:${Versioning.KOIN_VERSION}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versioning.RETROFIT_VERSION}"
    const val RETROFIT_CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:${Versioning.RETROFIT_VERSION}"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versioning.RETROFIT_VERSION}"
    const val MOSHI = "com.squareup.moshi:moshi:${Versioning.MOSHI_VERSION}"
    const val MOSHI_KOTLIN =  "com.squareup.moshi:moshi-kotlin:${Versioning.MOSHI_VERSION}"
    const val OKHTTP3_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versioning.OKHTTP3_LOGGING_INTERCEPTOR_VERSION}" //não alterar a versão problema com API 16

    const val PICASSO = "com.squareup.picasso:picasso:${Versioning.PICASSO_VERSION}"
    const val ANDROID_SPIN_KIT = "com.github.ybq:Android-SpinKit:1.4.0"
    const val INSTALL_REFERRES = "com.android.installreferrer:installreferrer:1.1"
    const val DEBUG_DB = "com.amitshekhar.android:debug-db:1.0.6"
    const val CHUCK_DEBUG = "com.readystatesoftware.chuck:library:1.1.0"
    const val CHUCK_RELEASE_NO_OP = "com.readystatesoftware.chuck:library-no-op:1.1.0"

    fun DependencyHandler.androidx() {
        implementation(APPCOMPAT)
        implementation(CORE_KTX)
        implementation(CONSTRAINT_LAYOUT)
        implementation(LEGACY_SUPPORT_V4)
        implementation(MULTIDEX)
        implementation(RECYCLER_VIEW)
        implementation(FRAGMENT)
    }

    fun DependencyHandler.lifecycle() {
        implementation(LIFECYCLE_VIEWMODEL)
        implementation(LIFECYCLE_EXTENSIONS)
        implementation(LIFECYCLE_COMMON_JAVA8)
    }

    fun DependencyHandler.navigation() {
        implementation(NAVIGATION_FRAGMENT_KTX)
        implementation(NAVIGATION_UI_KTX)
    }

    fun DependencyHandler.room() {
        implementation(ROOM_RUNTIME)
        kapt(ROOM_COMPILER)
        implementation(ROOM_KTX)
    }

    fun DependencyHandler.koin() {
        implementation(KOIN_CORE)
        implementation(KOIN_VIEW_MODEL)
    }

    fun DependencyHandler.kotlin() {
        api(KOTLIN_JAVA8)
        api(KOTLIN_REFLECT)
    }

    fun DependencyHandler.coroutines() {
        implementation(COROUTINES_CORE)
    }

    fun DependencyHandler.retrofit() {
        implementation(RETROFIT)
        implementation(RETROFIT_CONVERTER_MOSHI)
        implementation(RETROFIT_CONVERTER_GSON)
        implementation(OKHTTP3_LOGGING_INTERCEPTOR)
    }

    fun DependencyHandler.moshi() {
        implementation(MOSHI)
        implementation(MOSHI_KOTLIN)
    }


}

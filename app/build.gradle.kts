import config.Libs.androidx
import config.Libs.coroutines
import config.Libs.firebase
import config.Libs.koin
import config.Libs.lifecycle
import config.Libs.moshi
import config.Libs.navigation
import config.Libs.retrofit
import config.Libs.room
import config.TestLibs.androidxTest
import config.TestLibs.espresso
import config.TestLibs.mockk

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("jacoco")
}

jacoco {
    toolVersion = Versioning.JACOCO_VERSION
}

android {
    compileSdkVersion(Versioning.Android.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId = config.Android.APPLICATION_ID
        minSdkVersion(Versioning.Android.MIN_SDK_VERSION)
        targetSdkVersion(Versioning.Android.TARGET_SDK_VERSION)
        versionCode = Versioning.Android.APP_VERSION_CODE
        versionName = Versioning.Android.APP_VERSION_NAME
        testInstrumentationRunner = config.Android.TEST_INSTRUMENTATION_RUNNER
        testInstrumentationRunnerArgument("clearPackageData", "true")
        multiDexEnabled = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
            isTestCoverageEnabled = true
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    flavorDimensions("default")

    productFlavors {
        create("dev") {
            dimension = "default"
            applicationIdSuffix = ".dev"
            versionNameSuffix = ".dev"
        }
        create("stage") {
            dimension = "default"
            applicationIdSuffix = ".stage"
            versionNameSuffix = ".stage"
        }
        create("prod") {
            dimension = "default"
        }
    }

    buildFeatures {
        dataBinding = true
    }

    androidExtensions {
        isExperimental = true
    }

    packagingOptions {
        exclude("META-INF/LICENSE*")
    }

    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
        animationsDisabled = true
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    lintOptions {
        isCheckReleaseBuilds = false
        isQuiet = true
        isAbortOnError = true
        disable("MissingTranslation")
        baseline(file("${rootProject.projectDir}/config/lint/lint-baseline.xml"))
    }
}

tasks {
    withType<Test> {
        configure<JacocoTaskExtension> {
            isIncludeNoLocationClasses = true
        }
    }
}

dependencies {
    implementation(config.Libs.BIOMETRIC)

    implementation(config.Libs.ANDROID_IMAGE_CROPPER)
    implementation(config.Libs.LOTTIE)
    implementation(config.Libs.SHIMMER)
    implementation(config.Libs.SHAPE_OF_VIEW)
    implementation(config.Libs.FOTOAPPARAT)
    implementation(config.Libs.ANDROID_SPIN_KIT)
    implementation(config.Libs.INSTALL_REFERRES)
    implementation(config.Libs.BCPROV)
    implementation(config.Libs.VIEW_PAGER_DOT_INDICATOR)
    implementation(config.Libs.CHART_VIEW)
    implementation(config.Libs.SWIPE_REFRESH)
    releaseImplementation(config.Libs.CHUCK_RELEASE_NO_OP)

    debugImplementation(config.Libs.DEBUG_DB)
    debugImplementation(config.Libs.CHUCK_DEBUG)

    testImplementation(config.TestLibs.JUNIT4)
    testImplementation(config.TestLibs.JSON)
    testImplementation(config.TestLibs.TRUTH)

    androidTestUtil(config.TestLibs.ANDROIDX_TEST_ORCHESTRATOR)
    androidTestImplementation(config.TestLibs.TRUTH)

    androidx()
    lifecycle()
    room()
    firebase()
    koin()
    coroutines()
    navigation()
    retrofit()
    moshi()
    espresso()
    mockk()
    androidxTest()
}

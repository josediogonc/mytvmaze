buildscript {

    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }

    dependencies {
        classpath(config.BuildPlugins.ANDROID_PLUGIN)
        classpath(config.BuildPlugins.KOTLIN_PLUGIN)
        classpath(config.BuildPlugins.NAVIGATION_SAFE_ARGS_PLUGIN)
        classpath(config.BuildPlugins.JACOCO_PLUGIN)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

publishing {
    publications {
        register<MavenPublication>("pdfopt") {
            groupId = "com.github.axet"
            artifactId = "libk2pdfopt"
            version = "0.2.0"
            // 必须有这个 否则不会上传AAR包
            afterEvaluate { artifact(tasks.getByName("bundleReleaseAar")) }
            // 上传source，这样使用方可以看到方法注释
            //artifact generateSourcesJar
        }
    }
    repositories {
        maven {
        }
    }
}

android {
    namespace = "com.github.axet.libk2pdfopt"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        ndk {
            abiFilters += listOf("arm64-v8a")
        }
    }

    compileOptions {
        encoding = "UTF-8"
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs += "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
    }

    externalNativeBuild {
        cmake {
            path = File("CMakeLists.txt")
        }
    }
    android.ndkVersion = "29.0.13846066"
}

dependencies {
}
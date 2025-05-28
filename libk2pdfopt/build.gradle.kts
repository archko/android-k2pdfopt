plugins {
    id("com.android.library")
    id("kotlin-android")
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
    android.ndkVersion = "26.1.10909125"
}

/*signing {
    sign configurations.archives
}

// http://central.sonatype.org/pages/gradle.html

group = "com.github.axet"
archivesBaseName = "libk2pdfopt"
version = android.defaultConfig.versionName

uploadArchives {
    repositories {
        mavenDeployer {
            beforeDeployment { MavenDeployment deployment -> signing.signPom(deployment) }

            repository(url: "https://oss.sonatype.org/service/local/staging/deploy/maven2/") {
                authentication(userName: prop('ossrhUsername'), password: prop('ossrhPassword'))
            }

            snapshotRepository(url: "https://oss.sonatype.org/content/repositories/snapshots/") {
                authentication(userName: prop('ossrhUsername'), password: prop('ossrhPassword'))
            }

            pom.project {
                name 'android libk2pdfopt'
                packaging 'jar'
                description 'android libk2pdfopt.'
                url 'https://gitlab.com/axet/android-k2pdfopt'

                scm {
                    connection 'scm:git:https://gitlab.com/axet/android-k2pdfopt'
                    developerConnection 'scm:git:https://gitlab.com/axet/android-k2pdfopt'
                    url 'https://gitlab.com/axet/android-k2pdfopt'
                }

                licenses {
                    license {
                        name 'GNU GENERAL PUBLIC LICENSE 3+'
                        url 'https://www.gnu.org/licenses/gpl-3.0.en.html'
                    }
                }

                developers {
                    developer {
                        id 'axet'
                        name 'Alexey Kuznetsov'
                        email 'axet@me.com'
                    }
                }
            }
        }
    }
}*/

dependencies {
}

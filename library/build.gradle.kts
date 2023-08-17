@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.kotlin.kapt)
    `maven-publish`
}

sealed class Version(
    open val versionMajor: Int,
    val versionMinor: Int,
    val versionPatch: Int,
    val versionBuild: Int = 0
) {
    abstract fun toVersionName(): String
    class Beta(versionMajor: Int, versionMinor: Int, versionPatch: Int, versionBuild: Int) :
        Version(versionMajor, versionMinor, versionPatch, versionBuild) {
        override fun toVersionName(): String =
            "${versionMajor}.${versionMinor}.${versionPatch}-beta.$versionBuild"
    }

    class Stable(versionMajor: Int, versionMinor: Int, versionPatch: Int) :
        Version(versionMajor, versionMinor, versionPatch) {
        override fun toVersionName(): String = "${versionMajor}.${versionMinor}.${versionPatch}"
    }

    class ReleaseCandidate(
        versionMajor: Int, versionMinor: Int, versionPatch: Int, versionBuild: Int
    ) : Version(versionMajor, versionMinor, versionPatch, versionBuild) {
        override fun toVersionName(): String =
            "${versionMajor}.${versionMinor}.${versionPatch}-rc.$versionBuild"
    }
}

val currentVersion: Version = Version.Stable(
    versionMajor = 1,
    versionMinor = 0,
    versionPatch = 0,
)

android {
    namespace = "com.bobbyesp.valapi.library"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        version = currentVersion.toVersionName()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)

    //Network *Ktor*
    implementation(libs.bundles.ktor)

    //DI (Dependency Injection - Hilt)
    implementation(libs.bundles.hilt)
    kapt(libs.bundles.hilt.kapt)

    //Room
    implementation(libs.bundles.room)
    ksp(libs.room.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {
                name.set("ValAPI Library")
                description.set("A library for accessing the VALORANT API")
                url.set("https://github.com/BobbyEsp/ValAPI")

                developers {
                    developer {
                        id.set("BobbyEsp")
                        name.set("Gabriel Fontán")
                        email.set("gabilessto@gmail.com")
                    }
                }
                groupId = "com.bobbyesp.valapi"
                artifactId = "library"
                version = currentVersion.toVersionName()
            }

            afterEvaluate { artifact(tasks.getByName("bundleReleaseAar")) }
        }
    }
}

class RoomSchemaArgProvider(
    @get:InputDirectory @get:PathSensitive(PathSensitivity.RELATIVE) val schemaDir: File
) : CommandLineArgumentProvider {

    override fun asArguments(): Iterable<String> {
        return listOf("room.schemaLocation=${schemaDir.path}")
    }
}
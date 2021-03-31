plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    setCompileSdkVersion(30)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.testappe"
        minSdkVersion(22)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        // for inlining bytecode for some methods
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

repositories {
    maven("https://jitpack.io")
}

dependencies {
    val kotlin = "1.4.30"
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*,jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin")


    //oKhttp
    implementation("com.squareup.okhttp3:okhttp:4.9.0")



    val core = "1.3.2"
    implementation("androidx.core:core-ktx:$core")

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation("junit:junit:4.12")

    val testCore = "1.2.0"
    androidTestImplementation("androidx.test:core:$testCore")
    androidTestImplementation("androidx.test:core-ktx:$testCore")

    val extJUnit = "1.1.1"
    androidTestImplementation("androidx.test.ext:junit:$extJUnit")
    androidTestImplementation("androidx.test.ext:junit-ktx:$extJUnit")

    val testRunner = "1.1.0"
    androidTestImplementation("androidx.test:runner:$testRunner")

    val testRules = "1.2.0"
    androidTestImplementation("androidx.test:rules:$testRules")

    val espressoCore = "3.2.0"
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoCore")

    implementation("com.google.android.material:material:1.3.0")
}
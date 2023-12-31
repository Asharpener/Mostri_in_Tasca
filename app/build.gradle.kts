plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.mostri_in_tasca"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mostri_in_tasca"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dependencies {
        val nav_version = "2.7.5"

        // Java language implementation
        implementation("androidx.navigation:navigation-fragment:$nav_version")
        implementation("androidx.navigation:navigation-ui:$nav_version")

        // Kotlin
        implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
        implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

        // Feature module Support
        implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

        // Testing Navigation
        androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

        // Jetpack Compose Integration
        implementation("androidx.navigation:navigation-compose:$nav_version")
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:3.14.9")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


}



plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.dicoding.beescape"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dicoding.beescape"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //ui
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.google.android.material:material:1.10.0")

    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")

//    //testing
//    testImplementation "junit:junit:4.13.2"
//    androidTestImplementation "androidx.test.ext:junit:1.1.5"
//    androidTestImplementation "androidx.test.espresso:espresso-core:3.5.1"

//    //room
//    implementation "androidx.room:room-runtime:2.5.1"
//    kapt "androidx.room:room-compiler:2.5.1"

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.11.0")

    //coroutine support
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2") //viewModelScope
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2") //liveData
    implementation ("androidx.room:room-ktx:2.6.1")

    implementation("androidx.paging:paging-runtime-ktx:3.1.1")

    //compose
    implementation (platform("androidx.compose:compose-bom:2023.05.01"))
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.material3:material3")
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation ("androidx.activity:activity-compose:1.8.1")
    implementation ("androidx.compose.runtime:runtime-livedata") //observeAsState
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1") //ConstraintLayout
    implementation ("io.coil-kt:coil-compose:2.2.2") //AsyncImage

    implementation("androidx.datastore:datastore-core:1.0.0")
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.5")
    implementation ("androidx.navigation:navigation-compose:2.7.5")
    implementation("androidx.test.ext:junit-ktx:1.1.5")

    implementation ("androidx.paging:paging-compose:1.0.0-alpha12")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0-rc02")



//    implementation ("org.tensorflow:tensorflow-lite:2.4.0")
//    implementation ("org.tensorflow:tensorflow-lite-gpu:2.3.0")
//    implementation ("org.tensorflow:tensorflow-lite-task-vision-play-services:0.4.2")
//    implementation ("com.google.android.gms:play-services-tflite-gpu:16.1.0")

}
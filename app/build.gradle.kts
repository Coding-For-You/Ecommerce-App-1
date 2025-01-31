plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.ecommerceapp"
    compileSdk = 34

    buildFeatures{
        viewBinding =true
    }

    defaultConfig {
        applicationId = "com.example.ecommerceapp"
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // for dynamic sizes
    implementation ("com.github.MrNouri:DynamicSizes:1.0")
    /*Retrofit*/
    implementation ("com.google.code.gson:gson:2.8.9")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.0.1")
    implementation ("com.squareup.okhttp3:okhttp:4.9.2")
    implementation ("com.android.volley:volley:1.2.1")
    /*Todo circular image view*/
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    /*Glide lib for image load*/
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.9.0")

    // image carasaul
    implementation ("org.imaginativeworld.whynotimagecarousel:whynotimagecarousel:2.1.0")


}
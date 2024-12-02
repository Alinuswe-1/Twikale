plugins {
    id("com.android.application")

    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.twikale"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.twikale"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    implementation("androidx.navigation:navigation-fragment:2.8.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    //navigation
    implementation("androidx.navigation:navigation-compose:2.8.4")

    //dialog plus
    implementation("com.orhanobut:dialogplus:1.11@aar")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.14.2")
    // Skip this if you don't want to use integration libraries or configure Glide.
    annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")

    // Navigation
    implementation("androidx.navigation:navigation-fragment:2.8.4")
    implementation("androidx.navigation:navigation-ui:2.8.4")

    //firebase Bom
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))

    //firebase analytics
    implementation("com.google.firebase:firebase-analytics")

    //Authentication
    implementation("com.google.firebase:firebase-auth")

    //Fire-store
    implementation("com.google.firebase:firebase-firestore")

    //Storage
    implementation("com.google.firebase:firebase-storage")


}
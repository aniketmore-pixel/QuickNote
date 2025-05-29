plugins {
    id("com.android.application")
    id("kotlin-android")
    // Flutter plugin must be applied last
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.quicknote"

    // Set compileSdk to 34 or higher (your plugins want 34 or 35)
    compileSdk = 34

    // Set the NDK version to what your plugins require (27.0.12077973)
    ndkVersion = "27.0.12077973"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.example.quicknote"
        minSdk = 16           // or flutter.minSdkVersion if it's >=16
        targetSdk = 34        // match compileSdk

        versionCode = 1       // Or your flutter.versionCode if defined
        versionName = "1.0"   // Or your flutter.versionName if defined
    }

    buildTypes {
        release {
            // Use your own signing config here
            signingConfig = signingConfigs.getByName("debug")

            // Optional: Enable ProGuard or R8 for release
            // Fix for your error:
            isMinifyEnabled = true        // Enable code shrinking
            isShrinkResources = true      // Enable resource shrinking (optional but usually true)
        
            // Optional: use ProGuard or R8 config file
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

flutter {
    source = "../.."
}

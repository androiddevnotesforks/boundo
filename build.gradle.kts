/*
 * Copyright 2021 Clifford Liu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
//    "kotlin.dsl"
//    id("org.jetbrains.kotlin.kapt") version "1.3.20"
//    id("org.jetbrains.kotlin.android") version "1.3.20"
//    id("org.jetbrains.dokka-android") version "0.9.17"
}

buildscript {
    repositories {
        mavenCentral()
        google()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    val versions = object {
        val kotlin = "1.8.22"  // Compose Compiler 1.4.8 requires Kotlin 1.8.22
//        val dokka = "0.10.1" // dokka and dokka gradle plugin
//        val dokkaAndroidGradlePlugin = "0.9.18" // dokka android gradle plugin
        val googlePlayServicesOSSLicensesPlugin = "0.10.6"
        val androidGradlePlugin = "8.1.1"  // 8.1.1-Giraffe Patch 1
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${versions.androidGradlePlugin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}")
//        classpath("org.jetbrains.dokka:dokka-gradle-plugin:${versions.dokka}")
//        classpath("org.jetbrains.dokka:dokka-android-gradle-plugin:${versions.dokkaAndroidGradlePlugin}")
        classpath("com.google.android.gms:oss-licenses-plugin:${versions.googlePlayServicesOSSLicensesPlugin}")
    }
}

allprojects{
    repositories {
        mavenCentral()
        google()
    }
}

tasks{
    val clean by registering(Delete::class){
        delete(rootProject.buildDir)
    }
}

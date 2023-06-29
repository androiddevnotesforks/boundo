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

package com.cliuff.boundo.dependency

import org.gradle.api.Plugin
import org.gradle.api.Project

object Versions {
    const val androidxTestCore = "1.5.0"
    const val androidxTestRunner = "1.5.2"
    const val androidxTestExtJunit = "1.1.5"
    const val androidxTestEspresso = "3.5.1"

    const val androidxCore = "1.11.0-beta02"
    const val androidxComposeCompiler = "1.4.7"
    const val androidxComposeRuntime = "1.4.3"
    const val androidxComposeFoundation = "1.4.3"
    const val androidxComposeUi = "1.4.3"
    const val androidxComposeAnimation = "1.4.3"
    const val androidxComposeMaterial = "1.4.3"
    const val androidxComposeMaterial3 = "1.1.1"
    const val androidxActivity = "1.7.2"
    const val androidxAppcompat = "1.6.1"
    const val androidxLifecycle = "2.6.1"
    const val androidxRoom = "2.5.1"
    const val androidxNavigation = "2.5.3"
    const val androidxCoreTesting = "2.1.0"
    const val androidxFragment = "1.6.0"
    const val androidxWindow = "1.0.0"
    const val androidxDrawerLayout = "1.1.1"
    const val androidxSwipeRefreshLayout = "1.1.0"
    const val androidxConstraintLayout = "2.1.4"
    const val androidxConstraintLayoutCompose = "1.0.1"
    const val androidxPalette = "1.0.0"
    const val androidxCardView = "1.0.0"
    const val androidxRecyclerView = "1.2.1"
    const val androidxHeifWriter = "1.0.0"
    const val androidxDataBinding = "3.5.2"
    const val androidxViewPager = "1.0.0"
    const val androidxPaging = "3.1.1"
    const val androidxPreference = "1.2.0"
    const val androidxWork = "2.7.1"
    const val androidxDocumentFile = "1.0.1"

    const val androidxPercentLayout = "1.0.0"
    // This dependency is for the Wear UI Library,
    // which has classes that exemplify best practices
    const val androidxWear = "1.2.0"

    const val googleTruth = "1.1.3"
    const val googleMaterialComponents = "1.4.0"
    const val googlePlayServicesOSSLicenses = "17.0.0"
    const val googlePlayServicesBasement = "17.6.0"
    const val googleGson = "2.8.9"
    const val googlePlayFeatureDelivery = "2.1.0"
    const val googlePlayFeatureDeliveryKtx = "2.1.0"
    const val gglGuava = "31.0.1-android"
    // This dependency is set to compile only
    const val googleWearable = "2.8.1"
    const val googleAccompanistFlowLayout = "0.28.0"
    const val okhttp = "4.11.0"
    const val coil = "2.3.0"
    const val jsoup = "1.15.3"
    const val junit4 = "4.13.2"
    const val junitJupiter = "5.8.1"
    const val kotlin = "1.8.21"
    const val kotlinCoroutines = "1.6.4"
    const val mpChart = "v3.1.0"
    const val openCsv = "5.7.1"
    const val rxJava = "3.1.6"
    // Jetbrains annotations
    const val jbAnnotations = "24.0.0"
    const val androidDeviceNames = "2.1.1"
    const val byteBuddy = "1.12.22"
    const val androidDesugaring = "1.1.8"
    const val mockito = "5.1.1"
    // for checking apk dex, archived since 2019.11
    const val apkParser = "2.6.10"
    const val appIconLoader = "1.4.0"
    // Superellipse shape for Compose
    const val smoothCornerCompose = "v1.0.0"
    const val libCheckerRules = "32.1"
}

class Dependencies : Plugin<Project> {
    override fun apply(project: Project) {
        // Possibly common dependencies or can stay empty
    }

    companion object {
        // gradle plugins
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

        const val androidxTestCore = "androidx.test:core:${Versions.androidxTestCore}"
        const val androidxTestRunner = "androidx.test:runner:${Versions.androidxTestRunner}"
        const val androidxTestExtJunit = "androidx.test.ext:junit:${Versions.androidxTestExtJunit}"
        const val androidxTestEspresso = "androidx.test.espresso:espresso-core:${Versions.androidxTestEspresso}"

        const val androidxCore = "androidx.core:core:${Versions.androidxCore}"
        const val androidxCoreKtx = "androidx.core:core-ktx:${Versions.androidxCore}"
        const val androidxComposeRuntimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.androidxComposeRuntime}"
        const val androidxComposeFoundation = "androidx.compose.foundation:foundation:${Versions.androidxComposeFoundation}"
        const val androidxComposeUi = "androidx.compose.ui:ui:${Versions.androidxComposeUi}"
        // Integration with activities
        const val androidxComposeActivity = "androidx.activity:activity-compose:${Versions.androidxActivity}"
        // Compose Material Design
        const val androidxComposeMaterial3 = "androidx.compose.material3:material3:${Versions.androidxComposeMaterial3}"
        const val androidxComposeMaterialIcons = "androidx.compose.material:material:${Versions.androidxComposeMaterial}"
        const val androidxComposeMaterialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.androidxComposeMaterial}"
        const val androidxComposeAnimation = "androidx.compose.animation:animation:${Versions.androidxComposeAnimation}"
        // Tooling support (Previews, etc.)
        const val androidxComposeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.androidxComposeUi}"
        // Integration with ViewModels
        const val androidxComposeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.androidxLifecycle}"
        const val androidxComposeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.androidxComposeUi}"
        const val androidxActivity = "androidx.activity:activity-ktx:${Versions.androidxActivity}"
        const val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
        const val androidxFragment = "androidx.fragment:fragment-ktx:${Versions.androidxFragment}"
        const val androidxWindow = "androidx.window:window:${Versions.androidxWindow}"
        const val androidxDrawerLayout = "androidx.drawerlayout:drawerlayout:${Versions.androidxDrawerLayout}"
        const val androidxSwipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.androidxSwipeRefreshLayout}"
        const val androidxConstraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"
        const val androidxConstraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:${Versions.androidxConstraintLayoutCompose}"
        const val androidxPalette = "androidx.palette:palette:${Versions.androidxPalette}"
        const val androidxCardView = "androidx.cardview:cardview:${Versions.androidxCardView}"
        const val androidxRecyclerView = "androidx.recyclerview:recyclerview:${Versions.androidxRecyclerView}"
        const val androidxHeifWriter = "androidx.heifwriter:heifwriter:${Versions.androidxHeifWriter}"
        const val androidxDataBinding = "androidx.databinding:databinding-adapters:${Versions.androidxDataBinding}"
        const val androidxViewPager = "androidx.viewpager2:viewpager2:${Versions.androidxViewPager}"
        const val androidxDocumentFile = "androidx.documentfile:documentfile:${Versions.androidxDocumentFile}"

        const val androidxLifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle}"
        const val androidxLifecycleCommon = "androidx.lifecycle:lifecycle-common:${Versions.androidxLifecycle}"
        const val androidxLifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
        const val androidxLifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifecycle}"
        const val androidxCoreTesting = "androidx.arch.core:core-testing:${Versions.androidxCoreTesting}"
        const val androidxRoomRuntime = "androidx.room:room-runtime:${Versions.androidxRoom}"
        const val androidxRoomCompiler = "androidx.room:room-compiler:${Versions.androidxRoom}"
        const val androidxRoom = "androidx.room:room-ktx:${Versions.androidxRoom}"
        const val androidxRoomTesting = "androidx.room:room-testing:${Versions.androidxRoom}"
        const val androidxPaging = "androidx.paging:paging-runtime-ktx:${Versions.androidxPaging}"
        const val androidxPreference = "androidx.preference:preference-ktx:${Versions.androidxPreference}"
        const val androidxNavigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigation}"
        const val androidxNavigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigation}"
        const val androidxNavigationTesting = "androidx.navigation:navigation-testing:${Versions.androidxNavigation}"

        const val androidxWorkRuntime = "androidx.work:work-runtime-ktx:${Versions.androidxWork}"
        const val androidxWorkTesting = "androidx.work:work-testing:${Versions.androidxWork}"
        // optional - Firebase JobDispatcher support
        const val androidxWorkFirebase = "androidx.work:work-firebase:${Versions.androidxWork}"

        const val googleMaterialComponents = "com.google.android.material:material:${Versions.googleMaterialComponents}"
        const val googlePlayServicesOSSLicenses = "com.google.android.gms:play-services-oss-licenses:${Versions.googlePlayServicesOSSLicenses}"
        const val googlePlayServicesBasement = "com.google.android.gms:play-services-basement:${Versions.googlePlayServicesBasement}"
        const val googleAccompanistFlowLayout = "com.google.accompanist:accompanist-flowlayout:${Versions.googleAccompanistFlowLayout}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val coil = "io.coil-kt:coil:${Versions.coil}"
        const val coilCompose = "io.coil-kt:coil-compose:${Versions.coil}"
        const val jsoup = "org.jsoup:jsoup:${Versions.jsoup}"
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
        const val androidDesugaring = "com.android.tools:desugar_jdk_libs:${Versions.androidDesugaring}"

        const val googleTruth = "com.google.truth:truth:${Versions.googleTruth}"
        const val googleTruthExtensions = "com.google.truth.extensions:truth-java8-extension:${Versions.googleTruth}"
        const val googleGson = "com.google.code.gson:gson:${Versions.googleGson}"
        const val googlePlayFeatureDelivery = "com.google.android.play:feature-delivery:${Versions.googlePlayFeatureDelivery}"
        const val googlePlayFeatureDeliveryKtx = "com.google.android.play:feature-delivery-ktx:${Versions.googlePlayFeatureDeliveryKtx}"
        const val gglGuava = "com.google.guava:guava:${Versions.gglGuava}"
        const val junit4 = "junit:junit:${Versions.junit4}"
        const val junitJupiter = "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiter}"
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
        const val mpChart = "com.github.PhilJay:MPAndroidChart:${Versions.mpChart}"
        const val openCsv = "com.opencsv:opencsv:${Versions.openCsv}"
        const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava}"
        const val jbAnnotations = "org.jetbrains:annotations:${Versions.jbAnnotations}"
        const val androidDeviceNames = "com.jaredrummler:android-device-names:${Versions.androidDeviceNames}"
        const val byteBuddy = "net.bytebuddy:byte-buddy-android:${Versions.byteBuddy}"
        const val mockito = "org.mockito:mockito-android:${Versions.mockito}"
        const val apkParser = "net.dongliu:apk-parser:${Versions.apkParser}"
        const val appIconLoader = "me.zhanghai.android.appiconloader:appiconloader-iconloaderlib:${Versions.appIconLoader}"
        const val smoothCornerCompose = "com.github.racra:smooth-corner-rect-android-compose:${Versions.smoothCornerCompose}"
        const val libCheckerRules = "com.github.LibChecker:LibChecker-Rules-Bundle:${Versions.libCheckerRules}"

        // wear
        const val androidxPercentLayout = "androidx.percentlayout:percentlayout:${Versions.androidxPercentLayout}"
        const val androidxWear = "androidx.wear:wear:${Versions.androidxWear}"
        const val googleWearable = "com.google.android.wearable:wearable:${Versions.googleWearable}"

        val fileTreeValue = mapOf("dir" to "libs", "include" to listOf("*.jar"))

        val dynamicFeatureBasics = listOf(
                androidxCore,
                androidxCoreKtx,
                androidxComposeRuntimeLiveData,
                androidxComposeFoundation,
                androidxComposeUi,
                androidxComposeActivity,
                androidxComposeMaterial3,
                androidxComposeMaterialIcons,
                androidxComposeMaterialIconsExtended,
                androidxComposeAnimation,
                androidxComposeUiTooling,
                androidxComposeViewModel,
                androidxComposeUiTest,
                androidxActivity,
                androidxAppcompat,
                androidxFragment,
                androidxConstraintLayout,
                androidxLifecycleRuntime,
                androidxLifecycleCommon,
                androidxLifecycleViewModel,
                androidxLifecycleLiveData,
                googleMaterialComponents,
                googlePlayFeatureDelivery,
                googlePlayFeatureDeliveryKtx,
                gglGuava,
                jbAnnotations,
                okhttp,
                coil,
                coilCompose,
        )
    }
}

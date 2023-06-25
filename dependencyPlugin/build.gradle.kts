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

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object Versions {
    const val kotlin = "1.8.21"
}

buildscript {
    repositories {
        mavenCentral()
    }
    val versions = object {
        val kotlin = "1.8.21"
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}")
    }
}

plugins {
    val versions = object {
        val kotlin = "1.8.21"
    }
    kotlin("jvm") version versions.kotlin
    id("java-gradle-plugin")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
}

kotlin.jvmToolchain(11)

gradlePlugin {
    plugins {
        create("dependencies") {
            id = "com.cliuff.boundo.dependencies"
            implementationClass = "com.cliuff.boundo.dependency.Dependencies"
        }
    }
}

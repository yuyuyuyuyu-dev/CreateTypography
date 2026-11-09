import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.vanniktechMavenPublish)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.detekt)
}

ktlint {
    version = libs.versions.ktlintCli.get()
    filter {
        val buildPath =
            layout.buildDirectory
                .get()
                .asFile
                .toPath()
        exclude { it.file.toPath().startsWith(buildPath) }
    }
}

detekt {
    buildUponDefaultConfig = true
    config.setFrom(rootProject.files("config/detekt/detekt.yml"))
}

kotlin {
    android {
        namespace = "dev.yuyuyuyuyu.createtypography"
        compileSdk =
            libs.versions.android.compileSdk
                .get()
                .toInt()
        minSdk =
            libs.versions.android.minSdk
                .get()
                .toInt()
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
        androidResources {
            enable = true
        }
    }

    jvm("desktop")

    iosArm64()
    iosSimulatorArm64()

    js {
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.compose.ui.text.googlefonts)
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(
        groupId = "dev.yuyuyuyuyu",
        artifactId = "createtypography",
        version = "0.2.0",
    )

    pom {
        name = "CreateTypography"
        description =
            "A library for Android and Compose Multiplatform, provide functions that create Typography from font name or FontFamily."
        inceptionYear = "2025"
        url = "https://github.com/yuyuyuyuyu-dev/CreateTypography#readme"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                name = "yu"
                url = "https://yuyuyuyuyu.dev"
            }
        }
        scm {
            url = "https://github.com/yuyuyuyuyu-dev/CreateTypography"
            connection = "scm:git:git://github.com/yuyuyuyuyu-dev/CreateTypography.git"
            developerConnection = "scm:git:ssh://git@github.com/yuyuyuyuyu-dev/CreateTypography.git"
        }
    }
}

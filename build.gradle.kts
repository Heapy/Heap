import Dep.Kotlin
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm").version(Dep.kotlinVersion)
    application
}

repositories {
    jcenter()
}

subprojects {
    apply<KotlinPluginWrapper>()
    
    repositories {
        jcenter()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
        }
    }

    dependencies {
        implementation(Kotlin.stdlib)
    }
}

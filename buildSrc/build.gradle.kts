plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

val kotlinVersion = "1.5.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}

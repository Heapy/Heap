plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

val kotlinVersion = "1.4.31"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}

plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
}

val kotlinVersion = "1.4.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}

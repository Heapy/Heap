import Dep.Ktor

plugins {
    application
}

application {
    mainClassName = "io.heapy.heap.api.ApplicationKt"
}

dependencies {
    implementation(project(Module.frontend))
    implementation(project(Module.model))
    implementation(project(Module.service))

    implementation(Ktor.server)
    implementation(Ktor.jackson)
    implementation(Dep.logback)
    implementation(Dep.sentry)
}

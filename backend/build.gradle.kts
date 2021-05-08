plugins {
    id("komodo-crm-module-plugin")
    application
}

application {
    mainClass.set("io.heapy.crm.komodo.Application")
    applicationName = "backend"
}

dependencies {
    implementation(project(":backend-store-xodus"))
    implementation(undertow)
    implementation(config4k)
    implementation(slf4jApi)
    implementation(logback)
}

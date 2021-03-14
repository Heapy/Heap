plugins {
    id("komodo-crm-module-plugin")
}

dependencies {
    implementation(project(":backend-store-xodus"))
    implementation(undertow)
    implementation(config4k)
    implementation(slf4jApi)
    implementation(logback)
}

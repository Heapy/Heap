plugins {
    id("komodo-crm-module-plugin")
}

dependencies {
    implementation(jooqCodegen)
    implementation(flyway)
    implementation(postgresql)
}

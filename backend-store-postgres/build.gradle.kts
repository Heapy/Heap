plugins {
    id("komodo-crm-module-plugin")
}

dependencies {
    implementation(jooq)
    implementation(flyway)
    implementation(hikari)
    implementation(postgresql)
}

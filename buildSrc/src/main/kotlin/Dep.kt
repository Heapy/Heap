object Dep {
    const val kotlinVersion = "1.3.31"

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
        const val scriptUtil = "org.jetbrains.kotlin:kotlin-script-util:$kotlinVersion"
        const val scriptingCompiler = "org.jetbrains.kotlin:kotlin-scripting-compiler-embeddable:$kotlinVersion"
        const val compiler = "org.jetbrains.kotlin:kotlin-compiler-embeddable:$kotlinVersion"
    }

    object Ktor {
        private const val version = "1.2.1"
        const val server = "io.ktor:ktor-server-netty:$version"
        const val jackson = "io.ktor:ktor-jackson:$version"
    }

    val flyway = "org.flywaydb:flyway-core:5.2.4"
    val hikaricp = "com.zaxxer:HikariCP:3.3.1"

    private val jacksonVersion = "2.9.8"
    val jackson = "com.fasterxml.jackson.core:jackson-databind:$jacksonVersion"
    val jacksonJsr310 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion"
    val jacksonKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion"

    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.2.1"

    val httpClient = "org.apache.httpcomponents:httpasyncclient:4.1.4"
    val undertow = "io.undertow:undertow-core:2.0.20.Final"

    private val caffeineVersion = "2.6.2"
    val caffeine = "com.github.ben-manes.caffeine:caffeine:$caffeineVersion"
    val caffeineJCache = "com.github.ben-manes.caffeine:jcache:$caffeineVersion"

    private val jjwtVersion = "0.10.5"
    val jjwt = "io.jsonwebtoken:jjwt-api:$jjwtVersion"
    val jjwtImpl = "io.jsonwebtoken:jjwt-impl:$jjwtVersion"
    val jjwtJackson = "io.jsonwebtoken:jjwt-jackson:$jjwtVersion"

    val postgres = "org.postgresql:postgresql:42.2.4"

    val freemarker = "org.freemarker:freemarker:2.3.28"
    val rome = "com.rometools:rome:1.11.0"
    val sitemap = "com.github.dfabulich:sitemapgen4j:1.1.2"
    val jbcrypt = "org.mindrot:jbcrypt:0.4"

    val commonmark = "com.atlassian.commonmark:commonmark:0.12.1"

    val commonsEmail = "org.apache.commons:commons-email:1.5"

    private val micrometerVersion = "1.1.4"
    val micrometer = "io.micrometer:micrometer-core:$micrometerVersion"
    val micrometerPrometheus = "io.micrometer:micrometer-registry-prometheus:$micrometerVersion"

    const val logback = "ch.qos.logback:logback-classic:1.2.3"
    const val slf4jSimple = "org.slf4j:slf4j-simple:1.7.25"
    const val sentry = "io.sentry:sentry-logback:1.7.22"

    val mockk = "io.mockk:mockk:1.9.3"
    val junit = "org.junit.jupiter:junit-jupiter-engine:5.4.2"
}

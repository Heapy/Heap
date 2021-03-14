import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KomodoCRMModulePlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        pluginManager.apply("org.jetbrains.kotlin.jvm")

        repositories {
            mavenCentral()
            maven {
                url = uri("https://repo.kotlin.link")
            }
        }

        dependencies {
            add("implementation", kotlinStdlib)
            add("implementation", kotlinReflect)
            add("implementation", coroutines)
        }

        config()
        test()
    }

    private fun Project.config() {
        val bytecodeVersion = JavaVersion.VERSION_11

        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = bytecodeVersion.toString()
                languageVersion = "1.5"
                apiVersion = "1.5"
                useIR = true
            }
        }

        extensions.getByType<JavaPluginExtension>().apply {
            sourceCompatibility = bytecodeVersion
            targetCompatibility = bytecodeVersion
        }
    }

    private fun Project.test() {
        tasks.withType<Test>().configureEach {
            useJUnitPlatform()
        }

        dependencies {
            add("testImplementation", mockk)
            add("testImplementation", jupiterApi)
            add("testRuntimeOnly", jupiterEngine)
        }
    }
}

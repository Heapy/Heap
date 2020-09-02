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
            jcenter()
        }

        dependencies {
            add("implementation", Dep.kotlinStdlib)
            add("implementation", Dep.kotlinReflect)
            add("implementation", Dep.coroutines)
        }

        config()
        test()
    }

    private fun Project.config() {
        // Make sure that java's jvm target version is 8
        val bytecodeVersion = JavaVersion.VERSION_11

        tasks.withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = bytecodeVersion.toString()
            }
        }

        extensions.getByType<JavaPluginExtension>().apply {
            sourceCompatibility = bytecodeVersion
            targetCompatibility = bytecodeVersion
        }
    }

    private fun Project.test() {
        tasks.withType<Test> {
            useJUnitPlatform()
        }

        dependencies {
            add("testImplementation", Dep.mockk)
            add("testImplementation", Dep.jupiterApi)
            add("testRuntimeOnly", Dep.jupiterEngine)
        }
    }
}

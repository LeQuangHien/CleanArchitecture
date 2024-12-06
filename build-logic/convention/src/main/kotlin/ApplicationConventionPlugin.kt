import com.android.build.api.dsl.ApplicationExtension
import com.hienle.cleanarchitecture.gradle.convention.AppConfig
import com.hienle.cleanarchitecture.gradle.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = AppConfig.TARGET_SDK
            }
        }
    }
}
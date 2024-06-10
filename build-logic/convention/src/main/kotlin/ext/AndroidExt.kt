import com.android.build.api.dsl.CommonExtension
import org.gradle.api.artifacts.VersionCatalogsExtension

/**
 * Sets common values for Android Applications and Libraries
 */
fun org.gradle.api.Project.commonConfiguration(
    extension: CommonExtension<*, *, *, *, *, *>
) = extension.apply {
    compileSdk = versionCatalog.findVersion("compile-sdk").get().requiredVersion.toInt()

    defaultConfig {
        minSdk = versionCatalog.findVersion("min-sdk").get().requiredVersion.toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // The following argument makes the Android Test Orchestrator run its
        // "pm clear" command after each test invocation. This command ensures
        // that the app's state is completely cleared between tests.
//        testInstrumentationRunnerArguments["clearPackageData"] = "true"

    }
    buildFeatures {
        buildConfig = true
    }
}

fun org.gradle.api.Project.composeConfiguration(
    extension: CommonExtension<*, *, *, *, *, *>
) = extension.apply {
    buildFeatures {
        compose = true
    }
    composeOptions {
        val composeCompilerVersion = versionCatalog
            .findVersion("androidx-compose-compiler")
            .get()
            .requiredVersion
        kotlinCompilerExtensionVersion = composeCompilerVersion
    }
}

val org.gradle.api.Project.versionCatalog
    get() = extensions.getByType(VersionCatalogsExtension::class.java)
        .named("libs")
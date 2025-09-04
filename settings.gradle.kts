pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "TaskMate"
include(":shared", ":androidApp", ":desktopApp")

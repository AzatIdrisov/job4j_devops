dependencyResolutionManagement {
    versionCatalogs {
        create("devops") {
            library(
                "lombok",
                "org.projectlombok:lombok:1.18.36"
            )
            library(
                "springBootStarterWeb",
                "org.springframework.boot:spring-boot-starter-web:3.4.0"
            )
        }
        create("tests") {
            library(
                "springBootStarterTest",
                "org.springframework.boot:spring-boot-starter-test:3.4.0"
            )
            library(
                "junitPlatformLauncher",
                "org.junit.platform:junit-platform-launcher:1.9.3"
            )
            library(
                "assertjCore",
                "org.assertj:assertj-core:3.24.2"
            )
            library(
                "junitJupiter",
                "org.junit.jupiter:junit-jupiter:5.10.0"
            )
        }
    }
}

rootProject.name = "DevOps"

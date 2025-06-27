dependencyResolutionManagement {
    versionCatalogs {
        create("devops") {
            library(
                "lombok",
                "org.projectlombok:lombok:${
                    providers.gradleProperty("lombok.version").get()
                }"
            )
            library(
                "springBootStarterWeb",
                "org.springframework.boot:spring-boot-starter-web:${
                    providers.gradleProperty("spring.boot.version").get()
                }"
            )
        }
        create("tests") {
            library(
                "springBootStarterTest",
                "org.springframework.boot:spring-boot-starter-test:${
                    providers.gradleProperty("spring.boot.version").get()
                }"
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

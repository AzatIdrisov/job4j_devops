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

buildCache {
    remote<HttpBuildCache> {
        url = uri(System.getenv("GRADLE_REMOTE_CACHE_URL"))
        isAllowInsecureProtocol = true
        isAllowUntrustedServer = true
        isPush = System.getenv("GRADLE_REMOTE_CACHE_PUSH").toBoolean()
        credentials {
            username = System.getenv("GRADLE_REMOTE_CACHE_USERNAME")
            password = System.getenv("GRADLE_REMOTE_CACHE_PASSWORD")
        }
    }
}

rootProject.name = "DevOps"

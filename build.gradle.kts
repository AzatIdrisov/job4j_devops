plugins {
	checkstyle
	java
	jacoco
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
    id("com.github.spotbugs") version "6.0.26"
}

group = "ru.job4j.devops"
version = "1.0.0"

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.8".toBigDecimal()
            }
        }

        rule {
            isEnabled = false
            element = "CLASS"
            includes = listOf("org.gradle.*")

            limit {
                counter = "LINE"
                value = "TOTALCOUNT"
                maximum = "0.3".toBigDecimal()
            }
        }
    }
}

repositories {
	mavenCentral()
}

dependencies {
	compileOnly(devops.lombok)
	annotationProcessor(devops.lombok)
	implementation(devops.springBootStarterWeb)
	testImplementation(tests.springBootStarterTest)
	testRuntimeOnly(tests.junitPlatformLauncher)
	testImplementation(tests.junitJupiter)
	testImplementation(tests.assertjCore)
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.spotbugsMain {
    reports.create("html") {
        required = true
        outputLocation.set(layout.buildDirectory.file("reports/spotbugs/spotbugs.html"))
    }
}

tasks.test {
    finalizedBy(tasks.spotbugsMain)
}

tasks.register<Zip>("zipJavaDoc") {
    group = "documentation" // Группа, в которой будет отображаться задача
    description = "Packs the generated Javadoc into a zip archive"

    dependsOn("javadoc") // Указываем, что задача зависит от выполнения javadoc

    from("build/docs/javadoc") // Исходная папка для упаковки
    archiveFileName.set("javadoc.zip") // Имя создаваемого архива
    destinationDirectory.set(layout.buildDirectory.dir("archives")) // Директория, куда будет сохранен архив
}

tasks.register("checkSize") {
    group = "verification"
    description = "Checking JAR size."
    dependsOn("jar")
    doLast {
        val jarFile = file("build/libs/${project.name}-${project.version}.jar")
        if (jarFile.exists()) {
            val sizeInMB = jarFile.length()/(1024 * 1024)
            if (sizeInMB > 5) {
                logger.log(LogLevel.WARN, "JAR size exceeds 5 MB size limit. Current size: ${sizeInMB}")
            } else {
                logger.log(LogLevel.INFO, "JAR size is optimal. Current size: ${sizeInMB}")
            }
        } else {
            logger.log(LogLevel.ERROR, "JAR was not build. ")
        }
    }
}

tasks.register<Zip>("archiveResources") {
    group = "custom optimization"
    description = "Archives the resources folder into a ZIP file"

    val inputDir = file("src/main/resources")
    val outputDir = layout.buildDirectory.dir("archives")

    inputs.dir(inputDir) // Входные данные для инкрементальной сборки
    outputs.file(outputDir.map { it.file("resources.zip") }) // Выходной файл

    from(inputDir)
    destinationDirectory.set(outputDir)
    archiveFileName.set("resources.zip")

    doLast {
        println("Resources archived successfully at ${outputDir.get().asFile.absolutePath}")
    }
}

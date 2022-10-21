plugins {
  java
  id("io.quarkus")
}

repositories {
  mavenCentral()
  mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
  implementation("io.quarkus:quarkus-qute")
  implementation("io.quarkus:quarkus-smallrye-openapi")
  implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
  implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
  implementation("io.quarkus:quarkus-hibernate-reactive-panache")
  implementation("io.quarkus:quarkus-reactive-mysql-client")
  implementation("io.quarkus:quarkus-arc")
  implementation("io.quarkus:quarkus-resteasy-reactive")

  implementation("org.jetbrains:annotations:23.0.0")
  implementation("org.apache.commons:commons-lang3:3.12.0")
  implementation("commons-beanutils:commons-beanutils:1.9.4")

  compileOnly("org.projectlombok:lombok:1.18.24")
  annotationProcessor("org.projectlombok:lombok:1.18.24")

  testCompileOnly("org.projectlombok:lombok:1.18.24")
  testAnnotationProcessor("org.projectlombok:lombok:1.18.24")

  testImplementation("io.quarkus:quarkus-junit5")
  testImplementation("io.rest-assured:rest-assured")
}

group = "github.duanyuepeng"
version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<JavaCompile> {
  options.encoding = "UTF-8"
  options.compilerArgs.add("-parameters")
}

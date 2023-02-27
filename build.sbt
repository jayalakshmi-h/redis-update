ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

val chtLibJavaVersion = "1.0.8-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "redis-update",
    idePackagePrefix := Some("com.cloudheathtech.redis")
  )

libraryDependencies ++= Seq(
  "com.cloudhealthtech" % "cht-lib-java" % chtLibJavaVersion,
  "com.typesafe" % "config" % "1.4.2"

)

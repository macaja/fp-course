import Dependencies._

lazy val commonSettings = Seq(
  fork in run := true
)

lazy val root = (project in file(".")).
  settings(
    commonSettings,
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "fp-course",
    libraryDependencies += scalaTest % Test
  )

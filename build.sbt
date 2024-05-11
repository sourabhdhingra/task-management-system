import sbt.Keys.libraryDependencies
import Dependencies._

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "TaskManagementSystem"
)

libraryDependencies ++= Seq(
    scalaTestLibrary,
    scalaLangLibrary
)

name := """penguinhouse_api"""
organization := "com.penguinhouse"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies  ++= Seq(
  guice,
  jdbc,
  "mysql" % "mysql-connector-java" % "8.0.13",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "org.mockito" % "mockito-core" % "2.7.19" % Test
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.penguinhouse.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.penguinhouse.binders._"

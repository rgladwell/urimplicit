scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.10.4", "2.11.7")

organization := "me.gladwell"

licenses := Seq("LGPL-3.0" -> url("http://www.gnu.org/licenses/lgpl-3.0.html"))

scalacOptions ++= Seq(
  "-target:jvm-1.7",
  "-encoding", "UTF-8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlint",
  "-Ywarn-adapted-args",
  "-Ywarn-value-discard",
  "-Ywarn-inaccessible",
  "-Ywarn-dead-code",
  "-Yrangepos"
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.6.4" % "test"
)

publishMavenStyle := true

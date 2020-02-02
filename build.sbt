scalaVersion := "2.13.1"

crossScalaVersions := Seq("2.11.12", "2.12.5", "2.13.1")

organization := "me.gladwell.urimplicit"

organizationHomepage := Some(url("https://gladwell.me"))

licenses := Seq("LGPL-3.0" -> url("http://www.gnu.org/licenses/lgpl-3.0.html"))

homepage := Some(url("https://github.com/rgladwell/urimplicit"))

scalacOptions ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlint",
  "-Ywarn-value-discard",
  "-Ywarn-dead-code",
  "-Yrangepos"
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "4.6.0" % "test"
)

pomExtra := (
  <scm>
    <url>git@github.com:rgladwell/urimplicit.git</url>
    <connection>scm:git:git@github.com:rgladwell/urimplicit.git</connection>
  </scm>
  <developers>
    <developer>
      <id>rgladwell</id>
      <name>Ricardo Gladwell</name>
      <url>https://gladwell.me</url>
    </developer>
  </developers>)

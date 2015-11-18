scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.10.4", "2.11.7")

organization := "me.gladwell.urimplicit"

organizationHomepage := Some(url("https://gladwell.me"))

licenses := Seq("LGPL-3.0" -> url("http://www.gnu.org/licenses/lgpl-3.0.html"))

homepage := Some(url("https://github.com/rgladwell/urimplicit"))

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
  "org.specs2" %% "specs2-core" % "3.6.5" % "test"
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

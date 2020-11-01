ThisBuild / scalaVersion     := "2.13.3"
ThisBuild / organization     := "com.besselstudio"
ThisBuild / organizationName := "Bessel Studio"
ThisBuild / developers := List(
  Developer("raul782", "Raul Rodriguez", "raul@besselstudio.com", new URL("https://github.com/raul782"))
)

val projectName = "coingecko"
lazy val root = (project in file("."))
  .settings(
    name := projectName,
    libraryDependencies ++= Dependencies.common,
    licenses := Seq("Apache V2" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/besselstudio/coingecko"),
        "scm:git:git@github.com:besselstudio/coingecko.git"
      )
    ),
    crossScalaVersions := Seq(scalaVersion.value, "2.12.12"),
    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeSnapshots
      else
        Opts.resolver.sonatypeStaging
    ),
    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases"),
      Resolver.sonatypeRepo("snapshots")
    ),
    publishTo := sonatypePublishTo.value,
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false }
  )
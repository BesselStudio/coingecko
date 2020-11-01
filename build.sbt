ThisBuild / scalaVersion     := "2.13.3"
ThisBuild / organization     := "com.besselstudio"
ThisBuild / organizationName := "Bessel Studio"

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
    crossScalaVersions := Seq(scalaVersion.value, "2.12.12")
  )
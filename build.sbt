import ReleaseTransformations._

ThisBuild / scalaVersion     := "3.0.1"
ThisBuild / organization     := "com.besselstudio"
ThisBuild / organizationName := "Bessel Studio"
ThisBuild / homepage         := Some(url("https://github.com/besselstudio/coingecko"))
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
    scalacOptions ++= Seq(
      "-Xmax-inlines", "64" //Solves: Maximal number of successive inlines (32) exceeded
    ),
    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases"),
      Resolver.sonatypeRepo("snapshots")
    ),
    publishTo := sonatypePublishToBundle.value,
    publishMavenStyle := true,
    Test / publishArtifact := false,
    pomIncludeRepository := { _ => false },
    releaseCrossBuild := true,
    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies, // check that there are no SNAPSHOT dependencies
      inquireVersions, // ask user to enter the current and next version
      runClean, // clean
      runTest, // run tests
      setReleaseVersion, // set release version in version.sbt
      commitReleaseVersion, // commit the release version
      tagRelease, // create git tag
      releaseStepCommandAndRemaining("+publishSigned"), // run +publishSigned command to sonatype stage release
      releaseStepCommand("sonatypeBundleRelease"), // run sonatypeRelease and publish to maven central
      setNextVersion, // set next version in version.sbt
      commitNextVersion, // commit next version
      pushChanges // push changes to git
    )
  )
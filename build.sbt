import ReleaseTransformations._

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
    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases"),
      Resolver.sonatypeRepo("snapshots")
    ),
    publishTo := sonatypePublishToBundle.value,
    publishMavenStyle := true,
    publishArtifact in Test := false,
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
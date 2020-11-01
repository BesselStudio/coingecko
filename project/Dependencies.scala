import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.2" % Test
  lazy val playJson = "com.typesafe.play" %% "play-json" % "2.9.1"
  lazy val sttpClient = "com.softwaremill.sttp.client" %% "core" % "2.2.9"
  lazy val playJsonx = "ai.x" %% "play-json-extensions" % "0.42.0"

  lazy val common = Seq(
    scalaTest,
    playJson,
    sttpClient,
    playJsonx
  )
}

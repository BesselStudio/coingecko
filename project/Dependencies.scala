import sbt._

object Version {
  val sttpVersion = "3.3.6"
  val scalaTestVersion = "3.2.9"
  val playJsonVersion = "2.9.2"
  val playJsonxVersion = "0.42.0"
}

object Dependencies {
  import Version._
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.2" % Test
  lazy val playJson = "com.typesafe.play" %% "play-json" % playJsonVersion
  lazy val sttpClient = "com.softwaremill.sttp.client3" %% "core" % sttpVersion
  lazy val playJsonx = "ai.x" %% "play-json-extensions" % playJsonxVersion

  lazy val common = Seq(
    scalaTest,
    playJson,
    sttpClient,
    playJsonx
  )
}

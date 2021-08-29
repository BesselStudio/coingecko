import sbt._

object Version {
  val sttpVersion = "3.3.13"
  val scalaTestVersion = "3.2.9"
  val playJsonVersion = "2.10.0-RC5"
}

object Dependencies {
  import Version._
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.9" % Test
  lazy val playJson = "com.typesafe.play" %% "play-json" % playJsonVersion
  lazy val sttpClient = "com.softwaremill.sttp.client3" %% "core" % sttpVersion

  lazy val common = Seq(
    scalaTest,
    playJson,
    sttpClient
  )
}

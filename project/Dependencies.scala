import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"
  lazy val cats = "org.typelevel"  %% "cats-core"  % "0.9.0"  withSources()
  lazy val monix = "io.monix" %% "monix" % "2.3.0"
  lazy val monixCats = "io.monix" %% "monix-cats" % "2.3.0"
  lazy val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.13.4"
}

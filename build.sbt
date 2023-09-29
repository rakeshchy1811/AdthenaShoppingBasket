name := "ShoppingBasket"

version := "1.0"

scalaVersion := "3.3.1" // or the version you are using

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.10" % "test"
)

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.2.6"
)

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x                             => MergeStrategy.first
}

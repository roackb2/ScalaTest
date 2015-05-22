name := "test"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "Typesafe" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.3.11",
    "com.typesafe.akka" %% "akka-remote" % "2.3.11",
    "com.typesafe.akka" %% "akka-testkit"  % "2.3.11" % "test",
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4"

//    "com.typesafe.akka" % "akka-http-core-experimental_2.11" % "1.0-RC2",
//    "com.typesafe.play" % "play-iteratees_2.11" % "2.3.5",
//    "org.reactivemongo" %% "reactivemongo" % "0.10.5.0.akka23",
//    "org.reactivemongo" %% "play2-reactivemongo" % "0.10.5.0.akka23",
//    "com.typesafe.play" % "play-json_2.11" % "2.4.0-M2",
//    "ch.qos.logback" % "logback-classic" % "1.1.2"
)






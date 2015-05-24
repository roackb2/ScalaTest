name := "test"

version := "1.0"

scalaVersion := "2.11.6"

resolvers ++= Seq(
    "Typesafe" at "http://repo.typesafe.com/typesafe/releases/",
    "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/",
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
    "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)


libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.3.11",
    "com.typesafe.akka" %% "akka-remote" % "2.3.11",
    "com.typesafe.akka" %% "akka-testkit"  % "2.3.11" % "test",
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",

    /* database manipulation dependencies */
//    "com.typesafe.akka" % "akka-http-core-experimental_2.11" % "1.0-RC2",
//    "com.typesafe.play" % "play-iteratees_2.11" % "2.3.5",
//    "org.reactivemongo" %% "reactivemongo" % "0.10.5.0.akka23",
//    "org.reactivemongo" %% "play2-reactivemongo" % "0.10.5.0.akka23",
//    "com.typesafe.play" % "play-json_2.11" % "2.4.0-M2",
//    "ch.qos.logback" % "logback-classic" % "1.1.2"

    /* dependencies for matrix, ML and NLP */
    "org.scalanlp" %% "breeze" % "0.11.2",
    // native libraries are not included by default. add this if you want them (as of 0.7)
    // native libraries greatly improve performance, but increase jar sizes.
    "org.scalanlp" %% "breeze-natives" % "0.11.2"
)






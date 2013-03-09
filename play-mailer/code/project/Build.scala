import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "play-mailer"
    val libVersion      = "0.2-SNAPSHOT"

    val appDependencies = Seq(
        javaCore
    )

    val main = play.Project(appName, libVersion, appDependencies).settings(
      	version := libVersion,
     	  organization := "com.barreto",
      	libraryDependencies += "com.typesafe" % "play-plugins-mailer_2.10" % "2.1.0",
        publishArtifact in packageDoc := false
    )
}
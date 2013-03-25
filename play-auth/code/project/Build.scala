import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "play-auth"
    val appVersion      = "0.2.5-SNAPSHOT"

    val appDependencies = Seq(
        javaCore
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      organization := "com.clouidio",
      resolvers += "Apache" at "http://repo1.maven.org/maven2/",
      resolvers += "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",

      resolvers += "play-mailer (release)" at "http://clouidio.github.com/play-mailer/repo/releases/",
      resolvers += "play-mailer (snapshot)" at "http://clouidio.github.com/play-mailer/repo/snapshots/",

      libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.2.1",
      libraryDependencies += "com.clouidio" %% "play-mailer" % "0.2-SNAPSHOT",
      libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m",
      libraryDependencies += "commons-lang" % "commons-lang" % "2.6"
    )
}
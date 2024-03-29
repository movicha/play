import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "play-authenticate"
    val appVersion      = "0.2.5-SNAPSHOT"

    val appDependencies = Seq(
        javaCore
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      organization := "com.clouidio",
      resolvers += "Apache" at "http://repo1.maven.org/maven2/",
      resolvers += "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",

      resolvers += Resolver.url("play-mailer (release)", url("http://www.github.com/clouidio/play-mailer/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-mailer (snapshot)", url("http://www.github.com/clouidio/play-mailer/repo/snapshots/"))(Resolver.ivyStylePatterns),

      libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.2.1",
      libraryDependencies += "com.clouidio" %% "play-mailer" % "0.2-SNAPSHOT",
      libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m",
      libraryDependencies += "commons-lang" % "commons-lang" % "2.6"
    )
}
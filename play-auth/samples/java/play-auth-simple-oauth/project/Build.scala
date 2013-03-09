import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "play-authenticate-simple-oauth"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "be.objectify"  %%  "deadbolt-java"     % "2.1-SNAPSHOT",
      "com.clouidio"      %%  "play-authenticate" % "0.2.5-SNAPSHOT",
      javaCore,
      javaJdbc,
      javaEbean
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      resolvers += Resolver.url("Objectify Play Repository (release)", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("Objectify Play Repository (snapshot)", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns),

      resolvers += Resolver.url("play-mailer (release)", url("http://www.github.com/clouidio/play-mailer/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-mailer (snapshot)", url("http://www.github.com/clouidio/play-mailer/repo/snapshots/"))(Resolver.ivyStylePatterns),

      resolvers += Resolver.url("play-authenticate (release)", url("http://www.github.com/clouidio/play-authenticate/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-authenticate (snapshot)", url("http://www.github.com/clouidio/play-authenticate/repo/snapshots/"))(Resolver.ivyStylePatterns)
    )
}
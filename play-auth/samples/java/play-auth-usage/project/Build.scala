import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "play-auth-usage"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "be.objectify"  %%  "deadbolt-java"     % "2.1-SNAPSHOT",
      // Comment this for local development of the Play Authentication core
      "com.clouidio"      %%  "play-auth" % "0.2.5-SNAPSHOT",
      "postgresql"    %   "postgresql"        % "9.1-901-1.jdbc4",
      javaCore,
      javaJdbc,
      javaEbean
    )
    
//  Uncomment this for local development of the Play Authenticate core:
/*
    val playAuthenticate = play.Project(
      "play-auth", "1.0-SNAPSHOT", Seq(javaCore), path = file("modules/play-auth")
    ).settings(
      libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.2",
      libraryDependencies += "com.clouidio" %% "play-mailer" % "0.2-SNAPSHOT",
      libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m",
      libraryDependencies += "commons-lang" % "commons-lang" % "2.6",

      resolvers += Resolver.url("play-mailer (release)", url("http://www.github.com/clouidio/play/play-mailer/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-mailer (snapshot)", url("http://www.github.com/clouidio/play/play-mailer/repo/snapshots/"))(Resolver.ivyStylePatterns)
    )
*/

    val main = play.Project(appName, appVersion, appDependencies).settings(

      resolvers += Resolver.url("Objectify Play Repository (release)", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("Objectify Play Repository (snapshot)", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns),

      resolvers += Resolver.url("play-mailer (release)", url("http://www.github.com/clouidio/play/play-mailer/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-mailer (snapshot)", url("http://www.github.com/clouidio/play/play-mailer/repo/snapshots/"))(Resolver.ivyStylePatterns),

      resolvers += Resolver.url("play-auth (release)", url("http://www.github.com/clouidio/play/play-auth/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-auth (snapshot)", url("http://www.github.com/clouidio/play/play-auth/repo/snapshots/"))(Resolver.ivyStylePatterns)
    )
//  Uncomment this for local development of the Play Authenticate core:
//    .dependsOn(playAuthenticate).aggregate(playAuthenticate)

}

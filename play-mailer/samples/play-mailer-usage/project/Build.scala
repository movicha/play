import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "play-mailer-usage"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
    	javaCore,
      	"com.barreto" %% "play-mailer" % "0.2-SNAPSHOT"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      resolvers += Resolver.url("play-mailer (release)", url("http://alex.github.com/play-mailer/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-mailer (snapshot)", url("http://alex.github.com/play-mailer/repo/snapshots/"))(Resolver.ivyStylePatterns)
    )

}

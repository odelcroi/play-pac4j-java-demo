name := "play-pac4j-java-demo"

version := "8.0.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.5"

val playPac4jVersion = "8.0.0"
val pac4jVersion = "3.7.0"
val playVersion = "2.7.2"
val guiceVersion = "4.2.0"

val guiceDeps = Seq(
  "com.google.inject" % "guice" % guiceVersion,
  "com.google.inject.extensions" % "guice-assistedinject" % guiceVersion
)

libraryDependencies ++= Seq(
  guice,
  ehcache, // or cacheApi
  "org.pac4j" %% "play-pac4j" % playPac4jVersion,
  "org.pac4j" % "pac4j-http" % pac4jVersion,
  "org.pac4j" % "pac4j-cas" % pac4jVersion,
  "org.pac4j" % "pac4j-openid" % pac4jVersion exclude("xml-apis" , "xml-apis"),
  "org.pac4j" % "pac4j-oauth" % pac4jVersion,
  "org.pac4j" % "pac4j-saml" % pac4jVersion exclude("org.springframework", "spring-core"),
  "org.pac4j" % "pac4j-oidc" % pac4jVersion exclude("commons-io" , "commons-io"),
  "org.pac4j" % "pac4j-gae" % pac4jVersion,
  "org.pac4j" % "pac4j-jwt" % pac4jVersion exclude("commons-io" , "commons-io"),
  "org.pac4j" % "pac4j-ldap" % pac4jVersion,
  "org.pac4j" % "pac4j-sql" % pac4jVersion,
  "org.pac4j" % "pac4j-mongo" % pac4jVersion,
  "org.pac4j" % "pac4j-kerberos" % pac4jVersion exclude("org.springframework", "spring-core"),
  "org.pac4j" % "pac4j-couch" % pac4jVersion,
  "com.typesafe.play" % "play-cache_2.12" % playVersion,
  "commons-io" % "commons-io" % "2.4",
  "be.objectify" %% "deadbolt-java" % "2.6.1",//not used

  //For Java > 8
  "javax.xml.bind" % "jaxb-api" % "2.3.0",
  "javax.annotation" % "javax.annotation-api" % "1.3.2",
  "javax.el" % "javax.el-api" % "3.0.0",
  "org.glassfish" % "javax.el" % "3.0.0"

) ++ guiceDeps //For Play 2.6 & JDK9

resolvers ++= Seq( Resolver.mavenLocal,
  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/",
  "Sonatype snapshots repository" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Shibboleth releases" at "https://build.shibboleth.net/nexus/content/repositories/releases/")

routesGenerator := InjectedRoutesGenerator

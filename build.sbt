crossPaths := false
autoScalaLibrary := false

Compile / mainClass := Some("ch.irb.IgGenealogicTreeViewer.IgTreeViewer")

assembly / mainClass := (Compile / mainClass).value


ThisBuild / fork := true

libraryDependencies ++= List(
	"org.apache.logging.log4j" % "log4j-api" % "2.14.1",
	"org.apache.logging.log4j" % "log4j-1.2-api" % "2.14.1",
)

crossPaths := false
autoScalaLibrary := false

Compile / mainClass := Some("ch.irb.IgGenealogicTreeViewer.IgTreeViewer")

assembly / mainClass := (Compile / mainClass).value


ThisBuild / fork := true

libraryDependencies ++= List(
	"org.apache.logging.log4j" % "log4j-api" % "2.16.0",
	"de.erichseifert.vectorgraphics2d" % "VectorGraphics2D" % "0.13"
)

ThisBuild / assemblyMergeStrategy := {
  case "module-info.class"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
    oldStrategy(x)
}
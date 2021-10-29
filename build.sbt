crossPaths := false
autoScalaLibrary := false

Compile / mainClass := Some("ch.irb.IgGenealogicTreeViewer.IgTreeViewer")

assembly / mainClass := (Compile / mainClass).value


ThisBuild / fork := true

libraryDependencies ++= List(
	"com.sun.xml.bind" % "jaxb-impl" % "2.3.4",
	"com.sun.xml.bind" % "jaxb-xjc" % "2.3.4",
	"net.sourceforge.jexcelapi" % "jxl" % "2.6.12",
	// "org.apache.logging.log4j" % "log4j-api" % "2.14.1",
	// "org.apache.logging.log4j" % "log4j-1.2-api" % "2.14.1",
	"de.erichseifert.vectorgraphics2d" % "VectorGraphics2D" % "0.13"
)

ThisBuild / assemblyMergeStrategy := {
  case "module-info.class"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
    oldStrategy(x)
}
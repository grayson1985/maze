import scala.io.Source

object Main extends App {
    val filename = "maze.txt"
    val source = Source.fromResource(filename)
    val lines = source.getLines().toList
    source.close()


  /*val lines = List(
    "9 13",
    "#############",
    "eoo#o#ooo#oo#",
    "##o#o##o##o##",
    "#oooo#oo#ooox",
    "###o##o##o###",
    "#ooooooooooo#",
    "#####o###o###",
    "#ooooooooooo#",
    "#############"
  )*/
  val cells = (for {
    (arr, i) <- lines.tail.iterator.zipWithIndex
    (c, i2) <- arr.iterator.zipWithIndex
  } yield Cell(c, i2, i)).toList

  val maze = lines.headOption.map { firstLine =>
    val Array(rows, columns, _*) = firstLine.split("\\s+").map(_.toInt)
    Maze(rows, columns, cells)
  }.fold(Maze(0, 0, List.empty))(x => x)

  val path = maze.shortestPathFromEntrance

  println(s"Path: ${path.display}")
}
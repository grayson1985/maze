import scala.io.Source

object Main extends App {
  val filename = "maze.txt"
  val source = Source.fromFile(filename)
  val lines = source.getLines().toArray

  val mazeOpt = lines.headOption.map{ firstLine =>
    val Array(rows, columns, _*) = firstLine.split("\\s+").map(_.toInt)
    val data = lines.tail.map(s => s.toArray)

    val cells = (for{
      (arr, i) <- data.iterator.zipWithIndex
      (c, i2) <- arr.iterator.zipWithIndex
    } yield Cell(c, i, i2)).toArray


    Maze(rows, columns, cells)
  }



  source.close()



  println("Hello, World!")
}
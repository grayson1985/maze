case class Maze (
  rows: Int,
  columns: Int,
  cells: Array[Cell]
){

  def traverse: Path = {
    entrance.map{ e =>


    }
  }

  private def findExit(currentCell: Cell, exploredCells: Array[Cell]) = {

  }

  private def lookAtCell(currentCell: Cell, cellOpt: Option[Cell], exploredCells: Array[Cell]) = {
    cellOpt.map{ cell =>
      cell.value match {
        case 'e' => currentCell
        case '#' => currentCell
        case 'o' => cell
        case 'x' => cell
      }

    }
  }

  private def north(start: Cell) = {
    cells.find(c => c.xPosition == start.xPosition && c.yPosition == start.yPosition + 1)
  }

  private def west(start: Cell) = {
    cells.find(c => c.xPosition == start.xPosition - 1 && c.yPosition == start.yPosition)
  }

  private def east(start: Cell) = {
    cells.find(c => c.xPosition == start.xPosition + 1 && c.yPosition == start.yPosition)
  }

  private def south(start: Cell) = {
    cells.find(c => c.xPosition == start.xPosition && c.yPosition == start.yPosition - 1)
  }


  private def entrance = cells.find(_.value == 'e')
  private def walls = cells.filter(_.value == '#)
  private def openSpaces = cells.filter(_.value == 'o')
  private def exit = cells.find(_.value == 'x')
}

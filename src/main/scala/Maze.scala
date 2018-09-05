case class Maze(
  rows: Int,
  columns: Int,
  cells: List[Cell]
) {

  def shortestPathFromEntrance: Path = {
    cells.find(_.value == 'e').flatMap { entrance =>
      shortestPath(entrance, Path(List.empty))
    }.fold(Path(List.empty))(x => x)
  }

  private def shortestPath(current: Cell, path: Path): Option[Path] = {
    current.value match {
      case 'e' | 'o' =>

        val pathDown = down(current).flatMap(s => step(s, path))
        val pathLeft = left(current).flatMap(s => step(s, path))
        val pathUp = up(current).flatMap(s => step(s, path))
        val pathRight = right(current).flatMap(s => step(s, path))
        (pathUp ++ pathLeft ++ pathRight ++ pathDown)
          .reduceLeftOption((a, b) => if (a.steps.length < b.steps.length) a else b)

      case 'x' => Some(path)
      case '#' => None
    }
  }

  private def step(target: Step, path: Path) = {
    if (path.steps.map(_.start).contains(target.end)) None
    else shortestPath(target.end, Path(path.steps ::: List(target)))
  }

  private def up(current: Cell) = {
    cells.find(c => c.xPosition == current.xPosition && c.yPosition == current.yPosition - 1).map(nextCell =>
      Step(Up, current, nextCell)
    )
  }

  private def down(current: Cell) = {
    cells.find(c => c.xPosition == current.xPosition && c.yPosition == current.yPosition + 1).map(nextCell =>
      Step(Down, current, nextCell)
    )
  }

  private def right(current: Cell) = {
    cells.find(c => c.xPosition == current.xPosition + 1 && c.yPosition == current.yPosition).map(nextCell =>
      Step(Right, current, nextCell)
    )
  }

  private def left(current: Cell) = {
    cells.find(c => c.xPosition == current.xPosition - 1 && c.yPosition == current.yPosition).map(nextCell =>
      Step(Left, current, nextCell)
    )
  }

}

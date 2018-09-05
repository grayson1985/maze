
sealed trait Direction{
  def name: String
}
case object Up extends Direction {val name = "Up"}
case object Down extends Direction {val name = "Down"}
case object Right extends Direction {val name = "Right"}
case object Left extends Direction {val name = "Left"}

case class Step(
  direction: Direction,
  start: Cell,
  end: Cell
)
case class Path(
  steps: List[Step]
){
  def display: String = steps.map(_.direction).foldLeft("ENTRANCE")((a,b) => a + " => " + b) + " => EXIT"
}

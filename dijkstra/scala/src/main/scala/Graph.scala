trait Graph {
  def vertices: Seq[String]
}

class AdjGraph(
  private var data: Map[String, Seq[(String, Int)]] = Map.empty
) extends  Graph {
  def vertices: Seq[String] = {
    data.keys.toSeq.sorted
  }
}

object AdjGraph {
    def apply(edges: Seq[(String, Int, String)]): AdjGraph = {
        val data = edges.foldLeft(Map.empty[String, Seq[(String, Int)]])((acc, cur) => {
          cur match {
            case (from, distance, to) => {
              acc + (
                from -> ((to, distance) +: acc.getOrElse(from, Seq.empty)),
                to -> acc.getOrElse(to, Seq.empty)
              )
            }
          }
        })
        new AdjGraph(data)
    }
}

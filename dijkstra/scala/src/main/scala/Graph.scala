trait Graph {
  def vertices: Seq[String]
  def edges: Seq[(String, Int, String)]
}

class AdjGraph(
  private var data: Map[String, Seq[(String, Int)]] = Map.empty
) extends  Graph {
  def vertices: Seq[String] = {
    data.keys.toSeq.sorted
  }

  def edges: Seq[(String, Int, String)] = {
    data.flatMap(from => from._2.map(to => (from._1, to._2, to._1))).toSeq
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

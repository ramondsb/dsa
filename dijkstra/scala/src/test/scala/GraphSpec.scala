import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GraphSpec extends AnyFlatSpec with Matchers {
    val graph = AdjGraph(Seq(("a", 1, "b"), ("b", 2, "c")))

    "AdjGraph" should "returns an ordered sequence of all vertices" in {
        graph.vertices shouldBe Seq("a", "b", "c")
    }
    
    it should "returns a sequence of its edges" in {
        graph.edges should contain theSameElementsAs Seq(("b", 2, "c"), ("a", 1, "b"))
    }

    // TODO: graph.vertice("a").neigbours shouldBe Seq["b"]
    // TODO: Add edge
    // TODO: Remove edge
}

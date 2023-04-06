import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GraphSpec extends AnyFlatSpec with Matchers {
    val graph = AdjGraph(Seq(("a", 1, "b"), ("b", 2, "c")))

    "AdjGraph" should "return an ordered sequence of all vertices" in {
        graph.vertices shouldBe Seq("a", "b", "c")
    }
    
    it should "return a sequence of its edges" in {
        graph.edges should contain theSameElementsAs Seq(("b", 2, "c"), ("a", 1, "b"))
    }

    it should "return a sequence of neighbours" in {
        graph.neighbours("a") should contain theSameElementsAs Seq("b")
        graph.neighbours("c") should contain theSameElementsAs Seq()
        an [IllegalArgumentException] should be thrownBy graph.neighbours("z")
    }

    // TODO: Add edge
    // TODO: Remove edge
}


public class HeapDijkstrasNode {

	protected DijkstrasVertex vertex;
	protected Double value;
	
	public HeapDijkstrasNode(DijkstrasVertex vertex, Double value) {
		this.vertex = vertex;
		this.value = value;
	}
}

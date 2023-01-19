import java.util.HashMap;
import java.util.Map;

public class DijkstrasVertex {

	protected String value;
	protected Map<DijkstrasVertex, Double> routes = new HashMap<>();
	
	public DijkstrasVertex(String value) {
		this.value = value;
	}
	
	public void addRoute(DijkstrasVertex vertex, Double weight) {
		routes.put(vertex, weight);
	}
}

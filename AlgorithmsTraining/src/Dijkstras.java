import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Dijkstras {

	private Double lowerValue;
	
	public ArrayList<String> shortestPath(DijkstrasVertex vertexOrigin, 
			DijkstrasVertex vertexDestiny) {
		
		Map<String, Double> lowestValuesTable = new HashMap<>();
		Map<String, String> previousVertexLowerTable = new HashMap<>();
		
		HeapDijkstras unvisitedVertex = new HeapDijkstras();
		Map<String, Boolean> visitedVertex = new HashMap<>();
		
		lowestValuesTable.put(vertexOrigin.value, 0.0);
		
		DijkstrasVertex currentVertex = vertexOrigin;
		
		while(currentVertex != null) {
			visitedVertex.put(currentVertex.value, true);
			
			for (Map.Entry<DijkstrasVertex, Double> entry : currentVertex.routes.entrySet()) {
				if(!visitedVertex.containsKey(entry.getKey().value)) {
					unvisitedVertex.insert(entry.getKey(), 
							(lowestValuesTable.get(entry.getKey().value) == null)?
									Double.POSITIVE_INFINITY:
										lowestValuesTable.get(entry.getKey().value));
				}
				
				Double valueThroughCurrentVertex = lowestValuesTable.get(currentVertex.value)
						+ entry.getValue();
				
				if(!lowestValuesTable.containsKey(entry.getKey().value) || 
						valueThroughCurrentVertex < lowestValuesTable.get(entry.getKey().value)) {
					lowestValuesTable.put(entry.getKey().value, valueThroughCurrentVertex);
					previousVertexLowerTable.put(entry.getKey().value, currentVertex.value);
				}
			}
			currentVertex = unvisitedVertex.delete();
		}
		
		this.lowerValue = lowestValuesTable.get(vertexDestiny.value);
		
		ArrayList<String> shortPath = new ArrayList<>();
		String currentVertexValue = vertexDestiny.value;
		
		while(!currentVertexValue.equals(vertexOrigin.value)) {
			shortPath.add(currentVertexValue);
			currentVertexValue = previousVertexLowerTable.get(currentVertexValue);
		}
		
		shortPath.add(vertexOrigin.value);
		Collections.reverse(shortPath);
		
		return shortPath;
	}
	
	public Double getLowerValue() {
		return this.lowerValue;
	}
}

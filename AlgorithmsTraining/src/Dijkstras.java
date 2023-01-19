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
		
		ArrayList<DijkstrasVertex> unvisitedVertex = new ArrayList<>();
		Map<String, Boolean> visitedVertex = new HashMap<>();
		
		lowestValuesTable.put(vertexOrigin.value, 0.0);
		
		DijkstrasVertex currentVertex = vertexOrigin;
		
		while(currentVertex != null) {
			visitedVertex.put(currentVertex.value, true);
			unvisitedVertex.remove(currentVertex);
			
			for (Map.Entry<DijkstrasVertex, Double> entry : currentVertex.routes.entrySet()) {
				if(!visitedVertex.containsKey(entry.getKey().value)) {
					unvisitedVertex.add(entry.getKey());
				}
				
				Double valueThroughCurrentVertex = lowestValuesTable.get(currentVertex.value)
						+ entry.getValue();
				
				if(!lowestValuesTable.containsKey(entry.getKey().value) || 
						valueThroughCurrentVertex < lowestValuesTable.get(entry.getKey().value)) {
					lowestValuesTable.put(entry.getKey().value, valueThroughCurrentVertex);
					previousVertexLowerTable.put(entry.getKey().value, currentVertex.value);
				}
			}
			if(unvisitedVertex.size() <= 0) {
				currentVertex = null;
			}else {
				Double minValue = 0.0;
				for (DijkstrasVertex vertex : unvisitedVertex) {
					if(minValue == 0.0 || minValue > lowestValuesTable.get(vertex.value)) {
						minValue = lowestValuesTable.get(vertex.value);
						currentVertex = vertex;
					}
				}	
			}
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

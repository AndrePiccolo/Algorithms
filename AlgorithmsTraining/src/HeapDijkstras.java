import java.util.ArrayList;

public class HeapDijkstras {
private ArrayList<HeapDijkstrasNode> heap = new ArrayList<>();
	
	public ArrayList<HeapDijkstrasNode> getHeap(){
		return this.heap;
	}
	
	public void insert(DijkstrasVertex vertex, Double value) {
		heap.add(new HeapDijkstrasNode(vertex, value));
		Integer index_add_value = heap.size()-1;
		
		while(index_add_value > 0 && 
				heap.get(index_add_value).value < heap.get(parentIndex(index_add_value)).value) {
			HeapDijkstrasNode swap = heap.get(index_add_value);
			heap.set(index_add_value, heap.get(parentIndex(index_add_value)));
			heap.set(parentIndex(index_add_value), swap);
			index_add_value = parentIndex(index_add_value);
		}	
	}
	
	private Integer parentIndex(Integer index) {
		return (index-1)/2;
	}
	
	public DijkstrasVertex delete() {
		if(heap.size() <= 0) {
			return null;
		}
		
		DijkstrasVertex deleted = heap.get(0).vertex;
		
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		Integer movedRootIndex = 0;
		
		while(hasSmallerChild(movedRootIndex)) {
			Integer smallChildIndex = findSmallerChild(movedRootIndex);
			HeapDijkstrasNode swap = heap.get(movedRootIndex);
			heap.set(movedRootIndex, heap.get(smallChildIndex));
			heap.set(smallChildIndex, swap);
			
			movedRootIndex = smallChildIndex;
		}
		
		return deleted;
	}
	
	private Boolean hasSmallerChild(Integer index) {
		return (leftChildIndex(index) < heap.size() && 
				heap.get(leftChildIndex(index)).value < heap.get(index).value ||
				rigthChildIndex(index) < heap.size() &&
				heap.get(rigthChildIndex(index)).value < heap.get(index).value);
	}
	
	private Integer findSmallerChild(Integer index) {
		if(rigthChildIndex(index) > heap.size()-1) {
			return leftChildIndex(index);
		}else if(leftChildIndex(index) > heap.size()-1) {
			return rigthChildIndex(index);
		}else if(heap.get(leftChildIndex(index)).value > heap.get(rigthChildIndex(index)).value) {
			return rigthChildIndex(index);
		}else {
			return leftChildIndex(index);
		}
	}
	
	private Integer leftChildIndex(Integer index) {
		return(index * 2) + 1;
	}
	
	private Integer rigthChildIndex(Integer index) {
		return(index * 2) + 2;
	}
}


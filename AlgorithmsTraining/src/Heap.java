//Priority Queue - insertion: O(LogN) / deletion: O(LogN)

import java.util.ArrayList;

public class Heap {

	private ArrayList<Integer> heap = new ArrayList<>();
	
	public ArrayList<Integer> getHeap(){
		return this.heap;
	}
	
	public void insertMinValue(Integer value) {
		heap.add(value);
		Integer index_add_value = heap.size()-1;
		
		while(index_add_value > 0 && 
				heap.get(index_add_value) < heap.get(parentIndex(index_add_value))) {
			Integer swap = heap.get(index_add_value);
			heap.set(index_add_value, heap.get(parentIndex(index_add_value)));
			heap.set(parentIndex(index_add_value), swap);
			index_add_value = parentIndex(index_add_value);
		}	
	}
	
	
	public void insert(Integer value) {
		heap.add(value);
		Integer index_add_value = heap.size()-1;
		
		while(index_add_value > 0 && 
				heap.get(index_add_value) > heap.get(parentIndex(index_add_value))) {
			Integer swap = heap.get(index_add_value);
			heap.set(index_add_value, heap.get(parentIndex(index_add_value)));
			heap.set(parentIndex(index_add_value), swap);
			index_add_value = parentIndex(index_add_value);
		}	
	}
	
	private Integer parentIndex(Integer index) {
		return (index-1)/2;
	}
	
	public Integer delete() {
		Integer deleted = heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		Integer movedRootIndex = 0;
		
		while(hasGreaterChild(movedRootIndex)) {
			Integer largeChildIndex = findLargerChild(movedRootIndex);
			Integer swap = heap.get(movedRootIndex);
			heap.set(movedRootIndex, heap.get(largeChildIndex));
			heap.set(largeChildIndex, swap);
			
			movedRootIndex = largeChildIndex;
		}
		
		return deleted;
	}
	
	public Integer deleteSmallerValue() {
		Integer deleted = heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		Integer movedRootIndex = 0;
		
		while(hasSmallerChild(movedRootIndex)) {
			Integer smallChildIndex = findSmallerChild(movedRootIndex);
			Integer swap = heap.get(movedRootIndex);
			heap.set(movedRootIndex, heap.get(smallChildIndex));
			heap.set(smallChildIndex, swap);
			
			movedRootIndex = smallChildIndex;
		}
		
		return deleted;
	}
	
	private Boolean hasGreaterChild(Integer index) {
		return (leftChildIndex(index) < heap.size() && 
				heap.get(leftChildIndex(index)) > heap.get(index) ||
				rigthChildIndex(index) < heap.size() &&
				heap.get(rigthChildIndex(index)) > heap.get(index));
	}
	
	private Boolean hasSmallerChild(Integer index) {
		return (leftChildIndex(index) < heap.size() && 
				heap.get(leftChildIndex(index)) < heap.get(index) ||
				rigthChildIndex(index) < heap.size() &&
				heap.get(rigthChildIndex(index)) < heap.get(index));
	}
	
	private Integer findLargerChild(Integer index) {
		if(rigthChildIndex(index) > heap.size()-1) {
			return leftChildIndex(index);
		}else if(leftChildIndex(index) > heap.size()-1) {
			return rigthChildIndex(index);
		}else if(heap.get(leftChildIndex(index)) < heap.get(rigthChildIndex(index))) {
			return rigthChildIndex(index);
		}else {
			return leftChildIndex(index);
		}
	}
	
	private Integer findSmallerChild(Integer index) {
		if(rigthChildIndex(index) > heap.size()-1) {
			return leftChildIndex(index);
		}else if(leftChildIndex(index) > heap.size()-1) {
			return rigthChildIndex(index);
		}else if(heap.get(leftChildIndex(index)) > heap.get(rigthChildIndex(index))) {
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

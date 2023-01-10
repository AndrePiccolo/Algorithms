import java.util.List;

public class Quicksort {
	
	public void quicksort(List<Integer> sortArray, Integer leftIndex, Integer rightIndex){
		if(leftIndex < rightIndex) {
			Integer pivotIndex = partition(sortArray, leftIndex, rightIndex);
			quicksort(sortArray, leftIndex, pivotIndex-1);
			quicksort(sortArray, pivotIndex + 1, rightIndex);
		}
	}
	
	public Integer quickSelection(Integer lowestValue, List<Integer> sortArray,
			Integer leftIndex, Integer rightIndex) {

		Integer pivotindex = partition(sortArray, leftIndex, rightIndex);
		
		if(pivotindex == lowestValue-1) {
			return sortArray.get(pivotindex);
		}else if(lowestValue-1 < pivotindex) {
			return quickSelection(lowestValue, sortArray, leftIndex, pivotindex-1);
		}else{
			return quickSelection(lowestValue, sortArray, pivotindex + 1, rightIndex);
		}
	}
	
	private Integer partition(List<Integer> sortArray, Integer leftPointer, Integer rightPointer) {
		Integer pivotindex = rightPointer;
		Integer pivot = sortArray.get(rightPointer);
		rightPointer--;
		
		while(rightPointer >= 0) {
			while(sortArray.get(leftPointer)<pivot) {
				leftPointer++;
			}
			while(sortArray.get(rightPointer)>pivot) {
				rightPointer--;
			}
			if(leftPointer >= rightPointer) {
				break;
			}else {
				Integer swap = sortArray.get(leftPointer);
				sortArray.set(leftPointer, sortArray.get(rightPointer));
				sortArray.set(rightPointer, swap);
				leftPointer++;
			}
		}
		Integer swap = sortArray.get(leftPointer);
		sortArray.set(leftPointer, pivot);
		sortArray.set(pivotindex, swap);
		
		return leftPointer;
	}
}


public class BinarySearchOrderedArray {

	public static Integer binarySearch(Integer[] array, Integer searchValue) {
		Integer lower_boundary = 0;
		Integer upper_boundary = array.length - 1;
		
		while(lower_boundary <= upper_boundary) {
			Integer midpoint = (lower_boundary + upper_boundary)/2;
			
			Integer value_midpoint = array[midpoint];
			
			if(searchValue == value_midpoint) {
				return midpoint;
			}
			else if(searchValue < value_midpoint) {
				upper_boundary = midpoint - 1;
			}else {
				lower_boundary = midpoint + 1;
			}
		}
		return -1;
	}
}


public class SelectionSort {

	public static Integer[] selectionSort(Integer[] list) {
		for(int i = 0; i<list.length-1; i++) {
			Integer lowestNumberIndex = i;
			for(int j= i+1; j<list.length; j++) {
				if(list[j] < list[lowestNumberIndex]) {
					lowestNumberIndex = j;
				}
			}
			if(lowestNumberIndex != i) {
				Integer swap = list[i];
				list[i] = list[lowestNumberIndex];
				list[lowestNumberIndex] = swap;
			}
		}
		return list;
	}
}

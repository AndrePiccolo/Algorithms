
public class BubbleSort {

	public static Integer[] bubleSort(Integer[] list) {
		Integer unsortedUntilIndex = list.length -1;
		Boolean unsorted = false;
		while(!unsorted) {
			unsorted = true;
			for(int i=0; i<unsortedUntilIndex; i++) {
				if(list[i] > list[i+1]) {
					Integer swap;
					swap = list[i];
					list[i] = list[i+1];
					list[i+1] = swap;
					unsorted = false;
				}
			}
			unsortedUntilIndex -= 1;
		}
		return list;
	}
}
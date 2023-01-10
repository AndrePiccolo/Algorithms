
public class InsertionSort {
	public static Integer[] insertionSort(Integer[] list) {
		for(int index=1; index<list.length; index++) {
			Integer tempValue = list[index];
			Integer position = index-1;
			while(position >= 0) {
				if(list[position] > tempValue) {
					list[position+1] = list[position];
					position --;
				}else {
					break;
				}
			}
			list[position+1] = tempValue;
		}
		return list;
	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] exampleBinarySearch = new Integer[]{3, 17, 75, 80, 202};
//		System.out.println(BinarySearchOrderedArray.binarySearch(exampleBinarySearch, 17));
		
//		Integer[] exampleBubleSort = new Integer[]{65, 55, 45, 35, 25, 15, 10};
//		for (Integer integer : BubbleSort.bubleSort(exampleBubleSort)) {
//			System.out.print(integer + " ");
//	    }
		
//		Integer[] exampleDuplicate = new Integer[]{65, 55, 45, 35};
//		System.out.println(Support.hasDuplicateValue(exampleDuplicate));
		
//		Integer[] exampleSelectionSort = new Integer[]{65, 55, 45, 35, 25, 15, 10};
//		for (Integer integer : SelectionSort.selectionSort(exampleSelectionSort)) {
//			System.out.print(integer + " ");
		
//		Integer[] exampleInsertionSort = new Integer[]{10, 55, 45, 35, 25, 15, 65};
//		for (Integer integer : InsertionSort.insertionSort(exampleInsertionSort)) {
//			System.out.print(integer + " ");
//	    }
		
		//Hash Map exercise - 1 - page 131
//		Integer[] array1 = new Integer[] {1,2,3,4,5};
//		Integer[] array2 = new Integer[] {0,2,4,6,8};
//		List<Integer> intersec = new ArrayList<>();
//		HashMap<Integer, Boolean> hashedArray1 = new HashMap<>();
//		
//		for (Integer item : array1) {
//			hashedArray1.put(item, true);
//		}
//		
//		for (Integer item : array2) {
//			if(hashedArray1.containsKey(item)) {
//				intersec.add(item);
//			}
//		}
//		
//		System.out.println(intersec.toString());
		
		//Hash Map exercise - 2 - page 131
//		String[] stringArray = new String[] {"a","b","c","d","c","e","f"};
//		HashMap<String, Boolean> hash = new HashMap<>();
//		
//		for (String item : stringArray) {
//			if(hash.containsKey(item)) {
//				System.out.println("Duplicated value is: " + item);
//				break;
//			}else {
//				hash.put(item, true);
//			}
//		}
		
		//Hash Map exercise - 3 - page 131
//		String alphabet = "abcdefghijklmnopqrstuvwxyz";
//		String phrase = "the quick brown box jumps over a lazy dog";
//		HashMap<Character , Boolean> hash = new HashMap<>();
//		for(int pos=0; pos < phrase.length(); pos++) {
//			hash.put(phrase.charAt(pos), true);
//		}
//		for(int pos=0; pos < alphabet.length(); pos++) {
//			if(!hash.containsKey(alphabet.charAt(pos))) {
//				System.out.println("Missing letter: " + alphabet.charAt(pos));
//			}
//		}
		
		//Hash Map exercise - 4 - page 131
//		String test = "minimum";
//		HashMap<Character , Integer> hash = new HashMap<>();
//		for(int pos=0; pos<test.length(); pos++) {
//			if(hash.containsKey(test.charAt(pos))) {
//				hash.put(test.charAt(pos), hash.get(test.charAt(pos))+1);
//			}else {
//				hash.put(test.charAt(pos), 1);
//			}
//		}
//		for(int pos=0; pos<test.length(); pos++) {
//			if(hash.get(test.charAt(pos)) == 1) {
//				System.out.println("First non-duplcated character is: " + test.charAt(pos));
//				break;
//			}
//		}
		
//		Recursion rec = new Recursion();
//		for (String result : rec.anagram("abcdef")) {
//			System.out.println(result);
//		}
		
//		ArrayList<String> testEx1 = new ArrayList<>();
//		testEx1.add("ab");
//		testEx1.add("c");
//		testEx1.add("def");
//		testEx1.add("ghij");
//		System.out.println(rec.totalNumberChar(testEx1));
		
//		Integer[] exampleRecursion = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//		for (Integer integer : rec.evenNumbers(exampleRecursion)) {
//			System.out.println(integer);
//		}
		
//		System.out.println(rec.triangularNumber(10));
		
//		System.out.println(rec.findX("abcdefghijklmnopqrstuvwxyz"));
		
//		System.out.println(rec.uniquePaths(3, 7));
//		HashMap<List<Integer>, Integer> hash = new HashMap<>();
//		System.out.println(rec.uniquePaths(3, 6, hash));
		
//		List<Integer> orderList = new ArrayList<>(Arrays.asList(0, 5, 2, 1, 6, 3));
//		Quicksort algor = new Quicksort();
//		algor.quicksort(orderList, 0, 5);
//		for (Integer result : orderList) {
//			System.out.println(result + " ");
//		}
		
		List<Integer> orderList = new ArrayList<>(Arrays.asList(0, 5, 2, 1, 6, 3));
		Quicksort algor = new Quicksort();
		System.out.println(algor.quickSelection(6,orderList, 0, 5));
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Recursion {
	
	//Anagram Method
	public List<String> anagram(String word){
		
		if(word.length() == 1) {
			List<String> result = new ArrayList<>();
			result.add(word);
			return result;
		}
		
		List<String> result = new ArrayList<>();
		result = anagram(word.substring(1));
		
		List<String> resultAnagram = new ArrayList<>();
		
		for (String subAnagram : result) {
			for(int pos=0; pos <= subAnagram.length(); pos++) {
				String added = subAnagram.substring(0, pos) + word.charAt(0) + 
						subAnagram.substring(pos);
				resultAnagram.add(added);
			}
		}
		return resultAnagram;
	}
	
	// Exercise 1 - page 181
	public Integer totalNumberChar(ArrayList<String> array) {
		
		if(array.size()==1) {
			return array.get(0).length();
		}
		
		Integer totalSize = array.get(0).length();
		array.remove(0);
		return totalSize + totalNumberChar(array);
	}
	
	// Exercise 2 - page 181
	ArrayList<Integer> result = new ArrayList<>();
	
	public ArrayList<Integer> evenNumbers(Integer[] array) {
		if(array.length == 0) {
			return result;
		}
		
		if(array[0]%2 == 0) {
			result.add(array[0]);
		}
		
		evenNumbers(Arrays.copyOfRange(array, 1, array.length));
		
		return result;
	}
	
	// Exercise 3 - page 181
	public Integer triangularNumber(Integer number) {
		if(number == 1) {
			return 1;
		}
		return number + triangularNumber(number-1);
	}
	
	// Exercise 4 - page 182
	public Integer findX(String word) {
		return findXParamenter(word, 0);
	}
	
	private Integer findXParamenter(String word, Integer number) {
		if(word.length() == 0) {
			return -1;
		}
		if(word.charAt(0) == 'x') {
			return number;
		}
		return findXParamenter(word.substring(1), number + 1);
	}
	
	// Exercise 5 - page 182
	public Integer uniquePaths(Integer rows, Integer columns, HashMap<List<Integer>, Integer> hash) {
		if(rows == 1 || columns == 1) {
			return 1;
		}
		if(!hash.containsKey(Arrays.asList(rows, columns))) {
			hash.put(Arrays.asList(rows, columns), uniquePaths(rows - 1, columns, hash) +
					uniquePaths(rows, columns - 1,hash)); 
		}
		return hash.get(Arrays.asList(rows, columns));
	}
}

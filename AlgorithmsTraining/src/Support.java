import java.util.HashSet;
import java.util.Set;

public class Support {

	public static Boolean hasDuplicateValue(Integer[] list) {
		Set<Integer> store = new HashSet<>();
		for (Integer integer : list) {
			if(!store.add(integer)) {
				return true;
			}
		}
		return false;
	}
}

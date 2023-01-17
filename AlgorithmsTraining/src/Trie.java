import java.util.ArrayList;
import java.util.Map;

// O(K) efficiency, considering K the number of characters

public class Trie {

	private TrieNode rootNode;
	
	public Trie(){
		rootNode = new TrieNode();
	}
	
	public TrieNode search(String word) {
		TrieNode currentNode = this.rootNode;
		
		for(int i=0; i<word.length(); i++) {
			if(currentNode.trieNode.get(word.charAt(i)) != null) {
				currentNode = currentNode.trieNode.get(word.charAt(i));
			}else {
				return null;
			}
		}
		return currentNode;
	}
	
	public void insert(String word) {
		TrieNode currentNode = this.rootNode;
		
		for(int i=0; i<word.length(); i++) {
			if(currentNode.trieNode.get(word.charAt(i)) != null) {
				currentNode = currentNode.trieNode.get(word.charAt(i));
			}else {
				TrieNode addNode = new TrieNode();
				currentNode.trieNode.put(word.charAt(i), addNode);
				currentNode = addNode;
			}
		}
		currentNode.trieNode.put('*', null);
	}
	
	public ArrayList<String> getAllWords(TrieNode node){
		ArrayList<String> result = new ArrayList<>();
		collectAllWords(node, "", result);
		return result;
	}
	
	private void collectAllWords(TrieNode node, String word, ArrayList<String> words) {
		
		for (Map.Entry<Character, TrieNode> entry : node.trieNode.entrySet()) {
		    if(entry.getKey() == '*') {
		    	words.add(word);
		    }else {
			    collectAllWords(entry.getValue(), word+entry.getKey(), words);	
		    }
		}
	}
	
	public ArrayList<String> autoComplete(String prefix){
		TrieNode currentNode = search(prefix);
		if(currentNode == null) {
			return null;
		}else {
			return getAllWords(currentNode);
		}
	}
}

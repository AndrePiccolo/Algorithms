
public class LinkedList {
	
	private Node<String> firstNode;
	private Node<String> lastNode;
	
	public void insertEnd(String value) {
		Node<String> insertNode = new Node<String>(value);
		
		if(firstNode == null) {
			firstNode = insertNode;
			lastNode = insertNode;
		}else {
			insertNode.setPreviousNode(lastNode);
			lastNode.setNextNode(insertNode);
			lastNode = insertNode;
		}
	}
	
	public void insertFront(String value) {
		Node<String> insertNode = new Node<String>(value);
		
		if(firstNode == null) {
			firstNode = insertNode;
			lastNode = insertNode;
		}else {
			insertNode.setNextNode(firstNode);
			firstNode.setPreviousNode(insertNode);
			firstNode = insertNode;
		}
	}
	
	public String removeFront() {
		if(firstNode == null) {
			return "Empty list";
		}
		String result = firstNode.getData();
		firstNode = firstNode.getNextNode();
		return result;
	}
	
	public String removeEnd() {
		if(firstNode == null) {
			return "Empty list";
		}
		String result = lastNode.getData();
		lastNode = lastNode.getPreviousNode();
		return result;
	}
}

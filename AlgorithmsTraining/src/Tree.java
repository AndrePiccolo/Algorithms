// O(LogN) for insertion, deletion, search.

public class Tree{
	
	private TreeNode root;
	
	public Tree() {
		root = new TreeNode();
	}
	
	public void insert(Integer value) {
		if(root.data == null) {
			root.data = value;
		}else {
			insertNode(value, root);	
		}
	}
	
	private void insertNode(Integer value, TreeNode node) {
		if(value < node.data) {
			if(node.leftChild == null) {
				TreeNode newNode = new TreeNode();
				newNode.data = value;
				node.leftChild = newNode;
			}else {
				insertNode(value, node.leftChild);
			}
		}else {
			if(node.rigthChild == null) {
				TreeNode newNode = new TreeNode();
				newNode.data = value;
				node.rigthChild = newNode;
			}else {
				insertNode(value, node.rigthChild);
			}
		}
	}
	
	public TreeNode search(Integer value) {
		return searchNode(value, root);
	}
	
	private TreeNode searchNode(Integer value, TreeNode node) {
		if(node == null || node.data.equals(value)) {
			return node;
		}else {
			if(value < node.data) {
				return searchNode(value, node.leftChild);
			}else {
				return searchNode(value, node.rigthChild);
			}
		}
	}
	
	public void delete(Integer value) {
		deleteNode(value, root);
	}
	
	private TreeNode deleteNode(Integer value, TreeNode node) {
		System.out.println("Value to remove: " + value);
		if(node == null) {
			return node;
		}else if(value < node.data) {
			node.leftChild = deleteNode(value, node.leftChild);
			return node;
		}else if(value > node.data) {
			node.rigthChild = deleteNode(value, node.rigthChild);
			return node;
		}else {
			if(node.rigthChild == null) {
				return node.leftChild;
			}else if(node.leftChild == null) {
				return node.rigthChild;
			}else {
				node.rigthChild = removeNodeWithChildren(node.rigthChild, node);
				return node;
			}
		}
	}
	
	private TreeNode removeNodeWithChildren(TreeNode node, TreeNode nodeDelete) {
		if(node.leftChild != null) {
			node.leftChild = removeNodeWithChildren(node.leftChild, nodeDelete);
			return node;
		}else {
			nodeDelete.data = node.data;
			return node.rigthChild;
		}
	}
	
	public void printTreeNode() {
		print(root);
	}
	
	private void print(TreeNode node) {
		if(node == null) {
			return;
		}
		print(node.leftChild);
		System.out.println(node.data);
		print(node.rigthChild);
		
	}
}

package studyAlgorithm;

public class BinaryTree {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.nodeTest();
	}
	
	public void nodeTest() {
		Node[] nodes = new Node[16];
		for(int i = 1 ; i < nodes.length ; i++) {
			Node node = new Node(i,null,null);
			nodes[i] = node;
		}
		// 노드 연결해주는게 핵심. 부모노드에 짝수 홀수에 따라 연결해주기.
		for(int i = 2; i < nodes.length ; i++) {
			if(i%2 == 0) {
				nodes[i/2].leftChild = nodes[i];
			}else {
				nodes[i/2].rightChild = nodes[i];
			}
		}
		
		preOrder(nodes[1]);
		System.out.println();
		inOrder(nodes[1]);
		System.out.println();
		postOrder(nodes[1]);
	}
	
	public class Node{
		private int data;
		private Node leftChild;
		private Node rightChild;
		
		public Node(int data, Node leftChild, Node rightChild ) {
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}
	
	public void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}
	
	public void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.leftChild);
		System.out.print(node.data + " ");
		inOrder(node.rightChild);
	}
	
	public void postOrder(Node node) {
		if(node == null) {
			return;
		}
		postOrder(node.leftChild);
		postOrder(node.rightChild);
		System.out.print(node.data + " ");
	}
}

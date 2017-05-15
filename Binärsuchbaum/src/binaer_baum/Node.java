package binaer_baum;

public class Node<K extends Comparable<K>> {
	
	private K data;
	private Node<K> left, right;
	
	public Node(K data) {
		setData(data);
	}

	public K getData() {
		return data;
	}

	public void setData(K data) {
		this.data = data;
	}
	
	public Node<K> getLeft() {
		return left;
	}
	
	public void setLeft(Node<K> left) {
		this.left = left;
	}
	
	public Node<K> getRight() {
		return right;
	}
	
	public void setRight(Node<K> right) {
		this.right = right;
	}
	public String toString(){
		return "" + data;
	}
}
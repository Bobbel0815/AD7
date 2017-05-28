package binaer_baum;
/**
 * Interface des Knotens
 * @author acc378
 *
 * @param <K>
 */
public class Node<K extends Comparable<K>> {
	
	private K data;
	private Node<K> left, right;
	private int Sum;
	
	public Node(K data) {
		setData(data);
		this.Sum = (int) data;
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
	public int getSum(){
		return Sum;
	}
	public void setToSum(int sum){
		Sum += sum;
	}
}
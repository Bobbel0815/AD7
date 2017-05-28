package binaer_baum;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repräsentiert die Binärsuchbaum Implemenetierung mit Hilfe von
 * Referenzen zwischen den Knoten
 * 
 * @author soufian
 */
public class SuchBaumImp<T extends Comparable<T>> implements SuchBaum<T> {

	private Node<T> root = null;
	private int size = 0;

	/**
	 * Fügt einen Knoten dem Baum hinzu
	 * 
	 * 
	 * @param data
	 *            Die Daten die hinzugefügt werden
	 */
	@Override
	public void insert(T data) {
		if(root == null){
		root = new Node(data);
		}
		else{
			add(data,root);
		}
	}

	/**
	 * Rekursive Hilfsmethode zum durchsuchen des Baumes und zum finden einer
	 * gültigen Stelle in diesem
	 * 
	 * @param data
	 *            Daten des Knotens, node der einzufügende Knoten
	 */
	private void add(T data, Node<T> node) {
		// if (node != null) {
		// if (data == null) {
		// node.setRight(add(data, node.getRight()));
		// } else {
		// if (node.getData() == null) {
		// node = new Node<T>(data);
		// node.setRight(add(null, node.getRight()));
		// }
		 Node<T> newNode = new Node<T>(data);
		if (data.compareTo(node.getData()) < 0) {
			if (node.getLeft() == null) {
				
				node.setLeft(newNode);
				root.setToSum((int) data);
			}else {
				 add(data, node.getLeft());
			}
		}else if (data.compareTo(node.getData()) > 0) {
			if (node.getRight() == null) {
				
				node.setRight(newNode);
				
				root.setToSum((int) data);
			} else {
				add(data, node.getRight());
			}
		} else {
			// node = new Node<T>(data);
			System.out.println("Node already in tree!");
			// size++;
		}

		// return node;

	}

	/**
	 * Gibt den BSB in preorder Reihenfolge zurück
	 * 
	 * @return Eine Liste die den Baum in Preorder Reihenfolge enthält
	 */
	@Override
	public List<T> preOrder() {
		List<T> list = new ArrayList<T>();
		preOrder(root, list);
		return list;
	}

	/**
	 * Gibt den BSB in preOrder Reihenfolge zurück
	 * 
	 * @return Eine Liste die den Baum in postOrder Reihenfolge enthält
	 */

	private void preOrder(Node<T> node, List<T> list) {
		if (node != null) {
			list.add(node.getData());
			preOrder(node.getLeft(), list);
			preOrder(node.getRight(), list);
		}
	}

	/**
	 * Gibt den BSB in inOrder Reihenfolge zurück
	 * 
	 * @return Eine Liste die den Baum in inOrder Reihenfolge enthält
	 */
	@Override
	public List<T> inOrder() {
		List<T> list = new ArrayList<T>();
		inOrder(root, list);
		return list;
	}

	private void inOrder(Node<T> node, List<T> list) {
		if (node != null) {
			inOrder(node.getLeft(), list);
			list.add(node.getData());
			inOrder(node.getRight(), list);
		}
	}

	/**
	 * Gibt den BSB in postOrder Reihenfolge zurück
	 * 
	 * @return Eine Liste die den Baum in postOrder Reihenfolge enthält
	 */
	@Override
	public List<T> postOrder() {
		List<T> list = new ArrayList<T>();
		postOrder(root, list);
		return list;
	}

	private void postOrder(Node<T> node, List<T> list) {
		if (node != null) {
			postOrder(node.getLeft(), list);
			postOrder(node.getRight(), list);
			list.add(node.getData());
		}
	}

	/**
	 * Löscht den Baum
	 */
	public void clear() {
		root = null;
	}

	/**
	 * Gibt die Größe zurrück
	 * 
	 * @return size die Größe des Baumes
	 */
	public int size() {
		return this.size;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSumOfTwoNodes(int min, int max) {
int rootSum = root.getSum();
int leftSum = getSumSmallerMin(root, min);
int rightSum = getSumGreaterMax(root, max);
		if (min > max) {
			System.out.println("üngültige Werte");
			return -1;
		}
		return rootSum -leftSum- rightSum;
	}

	public int getSumSmallerMin(Node<T> node, int min) {

		if (node == null) {
			return 0;
		}
		if ((int) node.getData() == min) {
			if (node.getLeft() != null) {
				return node.getLeft().getSum();
			} else {
				return 0;
			}
		} else if (((int) node.getData() > min)) {
			return getSumSmallerMin(node.getLeft(), min);
		} else {
			int Sum = node.getSum();
			if (node.getLeft() != null) {

				Sum += (int) node.getLeft().getSum();
			}
			return Sum + getSumSmallerMin(node.getRight(), min);
		}

	}

	public int getSumGreaterMax(Node<T> node, int max) {

		if (node == null) {
			return 0;
		}
		if ((int) node.getData() == max) {
			if (node.getRight() != null) {
				return node.getRight().getSum();
			} else {
				return 0;
			}
		} else if (((int) node.getData() < max)) {
			return getSumGreaterMax(node.getRight(), max);
		} else {
			int Sum = node.getSum();
			if (node.getRight() != null) {
				Sum += (int) node.getRight().getSum();
			}
			return Sum + getSumGreaterMax(node.getLeft(), max);
		}

	}

}

// @Override
// public List<T> postOrder() {
// // TODO Auto-generated method stub
// return null;
// }

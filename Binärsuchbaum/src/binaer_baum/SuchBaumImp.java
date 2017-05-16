package binaer_baum;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repr�sentiert die Bin�rsuchbaum Implemenetierung mit Hilfe von Referenzen zwischen den Knoten
 * 
 * @author soufian
 */
public class SuchBaumImp<T extends Comparable<T>> implements SuchBaum<T> {

	private Node<T> root;
	private int size = 0;

	/**
	 * F�gt einen Knoten dem Baum hinzu
	 * 
	 * 
	 * @param data Die Daten die hinzugef�gt werden
	 */
	@Override
	public void insert(T data) {
		root = add(data, root);
	}

	/**
	 * Rekursive Hilfsmethode zum durchsuchen des Baumes und zum finden einer g�ltigen Stelle in diesem
	 * @param data Daten des Knotens, node der einzuf�gende Knoten
	 */
	private Node<T> add(T data, Node<T> node) {
		if (node != null) {
			if (data == null) {
				node.setRight(add(data, node.getRight()));
			} else {
				if (node.getData() == null) {
					node = new Node<T>(data);
					node.setRight(add(null, node.getRight()));
				}
				if (data.compareTo(node.getData()) < 0) {
					node.setLeft(add(data, node.getLeft()));
				}
				if (data.compareTo(node.getData()) > 0) {
					node.setRight(add(data, node.getRight()));
				}
			}
		} else {
			node = new Node<T>(data);
			size++;
		}

		return node;
	}


	/**
	 * Gibt den BSB in preorder Reihenfolge zur�ck
	 * 
	 * @return Eine Liste die den Baum in Preorder Reihenfolge enth�lt
	 */
	@Override
	public List<T> preOrder() {
		List<T> list = new ArrayList<T>();
		preOrder(root, list);
		return list;
	}
	
	/**
	 * Gibt den BSB in preOrder Reihenfolge zur�ck
	 * 
	 * @return Eine Liste die den Baum in postOrder Reihenfolge enth�lt
	 */

	private void preOrder(Node<T> node, List<T> list) {
		if (node != null) {
			list.add(node.getData());
			preOrder(node.getLeft(), list);
			preOrder(node.getRight(), list);
		}
	}

	/**
	 * Gibt den BSB in inOrder Reihenfolge zur�ck
	 * 
	 * @return Eine Liste die den Baum in inOrder Reihenfolge enth�lt
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
	 * Gibt den BSB in postOrder Reihenfolge zur�ck
	 * 
	 * @return Eine Liste die den Baum in postOrder Reihenfolge enth�lt
	 */
//	@Override
//	public List<T> postOrder() {
//		List<T> list = new ArrayList<T>();
//		postOrder(root, list);
//		return list;
//	}
	
	private void postOrder(Node<T> node, List<T> list) {
		if (node != null) {
			postOrder(node.getLeft(), list);
			postOrder(node.getRight(), list);
			list.add(node.getData());
		}
	}

	/**
	 * L�scht den Baum
	 */
	public void clear() {
		root = null;
	}

	/**
	 * Gibt die Gr��e zurr�ck
	 * @return size die Gr��e des Baumes
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

}
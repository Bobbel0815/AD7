package binaer_baum;

import java.util.ArrayList;
import java.util.List;

/**
 * BST
 * 
 * @author soufian
 */
public class SuchBaumImp<T extends Comparable<T>> implements SuchBaum<T> {

	private Node<T> root;
	private int size = 0;

	/**
	 * Adds a data entry to the BST
	 * 
	 * null is positive infinity
	 * 
	 * @param data The data entry to add
	 */
	@Override
	public void insert(T data) {
		root = add(data, root);
	}

	/**
	 * Recursive add() method helper
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
	 * Finds the pre-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in pre-order
	 */
	@Override
	public List<T> preOrder() {
		List<T> list = new ArrayList<T>();
		preOrder(root, list);
		return list;
	}

	private void preOrder(Node<T> node, List<T> list) {
		if (node != null) {
			list.add(node.getData());
			preOrder(node.getLeft(), list);
			preOrder(node.getRight(), list);
		}
	}

	/**
	 * Finds the in-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in in-order
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
	 * Finds the post-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in post-order
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
	 * Clears this BST
	 */
	public void clear() {
		root = null;
	}

	/**
	 * @return the size of this BST
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
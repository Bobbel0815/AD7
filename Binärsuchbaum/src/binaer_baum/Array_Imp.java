package binaer_baum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dieses Klasse implementiert den Binärsuchbaum mit hilfe eines arrays.
 * @author Dennis
 *
 * @param <T>
 */
public class Array_Imp<T extends Comparable<T>> implements SuchBaum<T> {
	Node<T> root;
	Node[] tree = new Node[4];
	int nodecnt = 0;

	@Override
	public void insert(T data) {
		if (tree[1] == null) {
			root = new Node(data);
			tree[1] = root;
		} else {
			Node newNode = new Node(data);
			int index = findIndex(1, newNode);
			fuegeEin(index, newNode);
		}

	}

	public int findIndex(int c, Node node) {
		if (tree[c] != null) // If current c is not empty
		{
			if (node.getData().compareTo(tree[c].getData()) > 0) // Go right to
																	// find an
																	// empty c
			{
				findIndex(c * 2 + 1, node);
			} else // Go left to find an empty c
			{
				findIndex(c * 2, node);
			}
		}
		return c;
	}

	/**
	 * Hilfsmethode zum finden des Indexes
	 */
	public int fuegeEin(int c, Node node) {
		if (c >= tree.length) {
			Node swap[] = new Node[tree.length * 2];
			System.arraycopy(tree, 0, swap, 0, tree.length);
			tree = swap;
		}
		if (node.getData().compareTo(tree[c].getData()) == -1) {
			// links einfuegen
			if (tree[c * 2] == null) {
				tree[c * 2] = node;
				nodecnt++;
			} else
				fuegeEin(c * 2, node);
		} else if (node.getData().compareTo(tree[c].getData()) == 1) {
			// rechts einfuegen
			if (tree[c * 2 + 1] == null) {
				tree[c * 2 + 1] = node;
				nodecnt++;
			} else
				fuegeEin(c * 2 + 1, node);
		} else {
			System.out.println("neuer Knoten existiert bereits!");
		}
		return c;
	}// fuegeEin

	public void fuegeEin(Node newKnoten) {
		int index = 1;
		if (tree[index] == null) {
			tree[index] = newKnoten;
			nodecnt++;
		} else {
			fuegeEin(index, newKnoten);
		}

	}

	@Override
	public List<T> preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> inOrder() {
		List<Node> list = Arrays.asList(tree);
		return (List<T>) list;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}

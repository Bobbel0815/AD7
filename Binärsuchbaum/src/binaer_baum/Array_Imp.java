package binaer_baum;

import java.util.List;

/**
 * Dieses Klasse implementiert den Binärsuchbaum mit hilfe eines arrays.
 * 
 * @author Dennis
 *
 *
 * @param <T>
 */
public class Array_Imp<T extends Comparable<T>> implements SuchBaum<T> {
	Node<T> root;
	Node<T>[] tree = new Node[4];
	int nodecnt = 0;

	@Override
	public void insert(T data) {
		if (tree[1] == null) {
			root = new Node(data);
			tree[1] = root;
		} else {
			Node newNode = new Node(data);

			fuegeEin(1, newNode);
		}

	}

	/**
	 * Hilfsmethode zum finden des Indexes
	 */
	public int fuegeEin(int index, Node node) {
		if (index * 2 + 1 >= tree.length) {
			Node swap[] = new Node[tree.length * 2];
			System.arraycopy(tree, 0, swap, 0, tree.length);
			tree = swap;
		}
		if (node.getData().compareTo(tree[index].getData()) == -1) {
			// links einfuegen
			if (tree[index * 2] == null) {
				tree[index * 2] = node;
			} else
				fuegeEin(index * 2, node);
		} else if (node.getData().compareTo(tree[index].getData()) == 1) {
			// rechts einfuegen
			if (tree[index * 2 + 1] == null) {
				tree[index * 2 + 1] = node;
			} else
				fuegeEin(index * 2 + 1, node);
		} else {
			System.out.println("neuer Knoten existiert bereits!");
		}
		return index;
	}// fuegeEin

	public void fuegeEin(Node newKnoten) {
		int index = 1;
		if (tree[index] == null) {
			tree[index] = newKnoten;
		} else {
			fuegeEin(index, newKnoten);
		}

	}
	
	/**
	 * Gibt den BSB in preOrder Reihenfolge aus
	 * 
	 */
	public void preOrder(int index) {
		System.out.println(tree[index].getData().toString);
		if (tree[index] != null) {
			if(postOrder(index*2) != null){
				postOrder(index*2);
			}
			if(postOrder(index*2+1) != null){
			postOrder(index*2+1);
			}
		}
	}
	
	/**
	 * Gibt den BSB in postOrder Reihenfolge aus
	 *
	 */
	public void postOrder(int index) {
		
		if (tree[index] != null) {
			if(postOrder(index*2) != null){
				postOrder(index*2);
			}
			if(postOrder(index*2+1) != null){
			postOrder(index*2+1);
					}
		System.out.println(tree[index].getData().toString);
		}
		
	/**
	 * Gibt den BSB in inOrder Reihenfolge aus
	 * 
	 */
	public List<T> inOrder() {
		List<Node> list = Arrays.asList(tree);
		return (List<T>) list;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}

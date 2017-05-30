package binaer_baum;

public class Main {

	public static void main(String[] args) {

		/* Creating object of SuchNode */
		SuchBaumImp<Integer> BST = new SuchBaumImp<Integer>();
		Array_Imp<Integer> BSTARRAY = new Array_Imp<Integer>();
		System.out.println("Binärsuchbaum");

		BST.insert(5);
		BST.insert(4);
		BST.insert(3);
		BST.insert(6);
		BST.insert(7);
		BST.printInOrder();
		System.out.println();
		BST.printPostoder();
		System.out.println();
		BST.printPreOder();
		System.out.println();
		System.out.println(BST.getSumOfTwoNodes(1,9));
		System.out.println(BST.getCounter());

	}
}

package binaer_baum;

public class Main {

	public static void main(String[] args) {

		/* Creating object of SuchNode */
		SuchBaumImp<Integer> BST = new SuchBaumImp<Integer>();
		Array_Imp<Integer> BSTARRAY = new Array_Imp<Integer>();
		System.out.println("Binärsuchbaum");

		BST.insert(5);
		BST.insert(4);
		BST.insert(7);
		BST.insert(3);
		BST.insert(6);
		
		System.out.println("\npostOrder: ");
		BST.printPostoder();
		System.out.println("\ninOrder: ");
		BST.printInOrder();
		System.out.println();
		System.out.println();
		System.out.println("\npreOrder: ");
		BST.printPreOder();
		System.out.println();
		System.out.println("\nSumme der durchlaufenden Knoten: "+BST.getSumOfTwoNodes(1,4));
		System.out.println("\nAufwand = "+BST.getCounter());

	}
}

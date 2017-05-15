package binaer_baum;

import java.util.Scanner;

public class Binaer_Baum {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of SuchNode */
		SuchBaumImp<Integer> bst = new SuchBaumImp<Integer>();
		System.out.println("Binary Search Tree Test\n");
		int choice;
		/* Perform tree operations */
		do {
			System.out.println("\nBinary Search Tree Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. Inorder");
			System.out.println("3. PreOrder");
			System.out.println("4. PostOrder");
			System.out.println("5. exit");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				bst.insert(scan.nextInt());
				break;
			case 2:
				System.out.println("InOrder");
				System.out.println(bst.inOrder());
				break;
			case 3:
				System.out.println("PreOrder");
				System.out.println(bst.preOrder());
				break;
			case 4:
				System.out.println("PostOrder");
				System.out.println(bst.postOrder());
				break;
			case 5:
				System.out.println("exit");
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			
		} while (choice != 5);
	}
}
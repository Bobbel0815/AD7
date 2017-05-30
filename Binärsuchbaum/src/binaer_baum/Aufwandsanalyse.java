package binaer_baum;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aufwandsanalyse {

	public static void main(String[] args) {

		
		for (int k = 1; k <= 4; k++) {
			
			int N = (int)Math.pow(10, k);
			System.out.println("\n"+N);
			SuchBaumImp<Integer>searchtree = new SuchBaumImp<Integer>();
			int[] random = new int[N];
			
			Random rn = new Random();

			for (int i = 0; i < random.length; i++) {

				random[i] = i;
			}

//			for (int h = 0; h < random.length; h++) {
//
//				System.out.println(random[h]);
//			}

			int index, temp;

			for (int j = random.length - 1; j > 0; j--) {
				index = rn.nextInt(j + 1);
				temp = random[index];
				random[index] = random[j];
				random[j] = temp;
			}
			
			System.out.println();
			int root =1;
			for (int l = 0; l < random.length; l++) {
				if(l==0){
					root =rn.nextInt((int)Math.pow(10,k));
					searchtree.insert(root);
				}else{
					if(l !=root){
					searchtree.insert(l);
					}
				}
				
//				System.out.println(random[l]);
			}
			
			 
			 
			
			for(int m=0;m<10; m++){
				int max = rn.nextInt((int)Math.pow(10,k));
				 //System.out.println("max="+max);
				 int min = rn.nextInt((int)Math.pow(10,k));
				// System.out.println("min ="+min);
				
				searchtree.getSumOfTwoNodes(min, max);
				System.out.print(" "+searchtree.getCounter());
				searchtree.resetCounter();
			}
//			if(k== 1){
//				System.out.print("\nBaum als Preorder ");
//				searchtree.printPreOder();
//			}
		}
		
		System.out.println();
		
		 
	}
}

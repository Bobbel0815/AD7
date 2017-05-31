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
	private int counter =0;

	/**
	 * Fügt einen Knoten dem Baum hinzu
	 * 
	 * 
	 * @param data
	 *            Die Daten die hinzugefügt werden
	 */
	@Override
	public void insert(T data) {
		if (root == null) {
			root = new Node(data);
		} else {
			add(data, root);
		}

	}

	/**
	 * Rekursive Hilfsmethode zum durchsuchen des Baumes und zum finden einer
	 * gültigen Stelle in diesem
	 * 
	 * @param data Daten des Knotens, node der einzufügende Knoten
	 */
	private void add(T data, Node<T> node) {

		Node<T> newNode = new Node<T>(data);
		if (data.compareTo(node.getData()) < 0) { 			// data kleiner als aktueller knoten?
			if (node.getLeft() == null) {        			//knoten hat linken sohn?
				node.setLeft(newNode);						// setzt knoten mit data als neuen linken sohn
				//node.setToSum((int) data);
				root.setToSum((int) data); 					// addiert die summe des knotens mit der wurzel summe
			} else {
				add(data, node.getLeft());					//knoten hat bereits linken sohn. aktueller knoten wird linker sohn
			}
		} else if (data.compareTo(node.getData()) > 0) { 	// data größer als aktueller knoten?
			if (node.getRight() == null) {					//knoten hat rechten sohn? 
				node.setRight(newNode); 					// setzt knoten mit data als neuen rechten sohn
				//node.setToSum((int) data);
				root.setToSum((int) data); 					// addiert die summe des knotens mit der wurzel summe
			} else {
				add(data, node.getRight());					//knoten hat bereits linken sohn. aktueller knoten wird rechter sohn
			}
		} else {
			System.out.println("Node already in tree!");	//knoten bereits im baum vorhanden
		}
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
	private void prinInOrder(Node node){
	    if(node != null) {
	        prinInOrder(node.getLeft());   
	        System.out.print(node.getData()+" ");
	        System.out.println(node.Sum);
	        prinInOrder(node.getRight());
	    }
	}
	    public void printInOrder() {
	        prinInOrder(root);
	    }
	    
	    private void printPostOrder(Node node) {
	    	int sum=0;
		    if(node != null) {
		        printPostOrder(node.getLeft());   
		        printPostOrder(node.getRight()); 
		        if(node.getLeft()!= null){
		        	sum+= node.getLeft().getSum();
		        }
		        if(node.getRight()!= null){
		        	sum+= node.getRight().getSum();
		        	
		        }
		        sum+=(int)node.getData();
		       node.Sum = sum;
		        System.out.print(node.getData()+" ");
		    }
		}
		    public void printPostoder() {
		        printPostOrder(root);
		    }
		    
		    private void printPreOrder(Node node) {
		    	
			    if(node != null) {
			    	System.out.print(node.getData()+" ");
			        printPreOrder(node.getLeft());
			        printPreOrder(node.getRight());  
			    }
			}
			    public void printPreOder() {
			        printPreOrder(root);
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

	/**
	 * Errechnet die Summe der Knoten die vom min bis max im Baum durchlaufen
	 * werden müssen.
	 * 
	 * @param min der startwert
	 * @param max der endwert
	 * @return
	 */
	public int getSumOfTwoNodes(int min, int max) {
		if (min > max) {
//			System.out.println("Werte getauscht");	//
			int swap=min;
			min = max;
			max = swap;
		}
		int rootSum = root.getSum();				//wurzelsumme	
		int leftSum = getSumSmallerMin(root, min);	//summe der knoten die kleiner als min sind
		int rightSum = getSumGreaterMax(root, max);	//summer der knoten die größer als max sind
		
		return rootSum - leftSum - rightSum; //rechnung zum ermitteln der summe 
	}

	/**
	 * hilfsmethode zum finden der summe des linken teilbaums
	 * 
	 * @param node aktueller knoten
	 * @param min übergener min wert
	 * @return
	 */
	public int getSumSmallerMin(Node<T> node, int min) {
		counter++;
		if (node == null) {									//abbruchbedingung der rekursiven mehthode. aktueller knoten nicht vorhanden
			return 0;
		}
		if ((int) node.getData() == min) {					//knoten ist gleich min = minimum gefunden 											
			if (node.getLeft() != null) {					//knoten besitz linken sohn
				return node.getLeft().getSum();				//summe des linken sohnes zurückgeben
			} else {
				return 0;									//knoten hat keinen linken sohn return 0
			}
		} else if (((int) node.getData() > min)) {			//knoten ist größer als min 
			return getSumSmallerMin(node.getLeft(), min);	//linken sohn als aktuellen knoten setzen
		} else {											//knoten ist kleiner als min ->summe des aktullen knotens setzen
			int Sum = 0;			//
			if (node.getLeft() != null) {					//wenn linker sohn vorhanden summe des sohnes addieren

				 Sum+= (int) node.getLeft().getSum()+(int)node.getData();
			}
			return Sum + getSumSmallerMin(node.getRight(), min);	//rekursiver aufruf
		}

	}

	/**
	 * hilfsmethode zum finden der summe des rechten teilbaums
	 * 
	 * @param node aktueller knoten
	 * @param max übergebner max wert
	 * @return
	 */
	public int getSumGreaterMax(Node<T> node, int max) {
		counter++;
		if (node == null) {										//abbruchbedingung der rekursiven mehthode. aktueller knoten nicht vorhanden
			return 0;												
		}
		if ((int) node.getData() == max) {						//knoten ist gleich max = maximum gefunden 
			if (node.getRight() != null) {						//knoten besitz rechten sohn
				return node.getRight().getSum();	            //summe des rechten sohnes zurückgeben
			} 
			else {
				return 0;										//knoten hat keinen linken sohn return 0
			}
		} else if (((int) node.getData() < max)) {				//knoten ist kleiner als max
			return getSumGreaterMax(node.getRight(), max);		//rechten sohn als aktuellen knoten setzen
		} else {												//knoten ist größer als max ->summe des aktullen knotens setzen
			int Sum = 0;
			if (node.getRight() != null) {						//wenn rechter sohn vorhanden summe des sohnes addieren
				Sum += (int) node.getRight().getSum()+(int)node.getData();
			}
			return Sum + getSumGreaterMax(node.getLeft(), max);	//rekursiver aufruf
		}	

	}
	public int getCounter(){
		return counter;
	}
	public void resetCounter(){
		counter = 0;
	}

}

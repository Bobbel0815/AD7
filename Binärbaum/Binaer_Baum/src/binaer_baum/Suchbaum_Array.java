package binaer_baum;

public class Suchbaum_Array <T extends Comparable<T>> implements Such{
private Knoten wurzel = null;
	void einfügen(Knoten node,T wert){
		Knoten neuerKnoten = new Knoten(wert);
		if (wurzel == null){
			wurzel = neuerKnoten;
		}
		else{
			Knoten aktuellerKnoten = wurzel;
			Knoten elternKnoten;
			
			while(true){
				elternKnoten = aktuellerKnoten;
				if(wert.compareTo((T) node.inhalt) <0){
					if(node.linkerSohn == null){
						node.linkerSohn = new Knoten<T>(wert);
					}
					else{
						einfügen(node.linkerSohn, wert);
					}
						
					
				}
			}
		}
	}

}

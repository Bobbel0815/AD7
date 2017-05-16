package binaer_baum;
/**
 * Das Interface des Suchbaumes
 */
import java.util.List;

public interface SuchBaum<T> {
	
	 void insert(T data);
	 public List<T> preOrder();
	 public List<T> postOrder();
	 public List<T> inOrder();
	 public void clear();
}

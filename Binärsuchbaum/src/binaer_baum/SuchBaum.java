package binaer_baum;

import java.util.List;

public interface SuchBaum<T> {
	
	 void insert(T data);
	 public List<T> preOrder();
	 public List<T> postOrder();
	 public List<T> inOrder();
	 public void clear();
}

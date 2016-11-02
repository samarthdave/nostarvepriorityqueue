//Code by Samarth Dave
import java.util.ArrayList;
public class NSPQ<E> {
	ArrayList<PriorityNode<E>> al;
	public NSPQ() {
		al = new ArrayList<>();
	}
	public boolean empty() {
		return size()==0;
	}
	public int size() {
		return al.size();
	}
	public void clear() {
		al.clear();
	}
	public void add(PriorityNode<E> item) {
		if(size() == 0) {
			al.add(item);
			return;
		}
		int i;
		for(i = size()-1; i>=0; i--) {
			if(item.getPriority() < al.get(i).getPriority()) {
				if(i+1 < size())
					al.set(i+1, al.get(i));
				else
					al.add(i+1, al.get(i));
			} else break;
		}
		if(i+1 >= size())
			al.add(i+1, item);
		else
			al.set(i+1, item);
	}
	public PriorityNode<E> remove() {
		if(empty())
			return null;
		PriorityNode<E> temp = al.get(0);
		if(size() == 1) {
			clear();
			return temp;
		}
		al.remove(0);
		for(PriorityNode<E> p: al) {
			p.setPriority(p.getPriority()-1);
		}
		return temp;
	}
	public String toString() {
		return al+"";
	}
}
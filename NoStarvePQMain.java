//Code by Samarth Dave
import java.util.Scanner;
public class NoStarvePQMain {
	static Scanner s;
	public static void main(String[] args) {
		System.out.println("No Starve Priority Queue by Samarth Dave");
		s = new Scanner(System.in);
		NSPQ<String> pq = new NSPQ<>();
		int sel = -1;
		do {
			out("1. Print\n2. Size\n3. Empty?\n4. Add\n5. Remove\n6. Clear\n0. Exit");
			sel = validInt("Enter selection: ");
			switch(sel) {
				case 1:
					out("The data in the priority queue is " + pq + ".");
					break;
				case 2:
					out("The size of the priority queue is " + pq.size() + ".");
					break;
				case 3:
					System.out.println(pq.empty() ? "The priority queue is empty." : "The priority queue is not empty.");
					break;
				case 4:
					System.out.print("\nEnter the string you want to add: ");
					String g = s.nextLine();
					int p = validInt("What is the priority of this string: ");
					PriorityNode<String> pn1 = new PriorityNode<>(g, p);
					pq.add(pn1);
					break;
				case 5:
					out(pq.empty() ? "The priority queue is empty. You cannot remove." : pq.remove() + " has been removed.");
					break;
				case 6:
					if(pq.empty()) {
						out("The priority queue is empty. You cannot clear.\n");
					} else {
						pq.clear();
						out("The priority queue has been emptied.\n");
					}
					break;
			}
		} while(sel != 0);
		s.close();
		out("User exited.");
	}
	public static int validInt(String o) {
		int r = -1;
		System.out.print("\n"+o);
		while(!s.hasNextInt()) {
			System.out.print("Error, try again: ");
			s.next();
		}
		r = s.nextInt();
		s.nextLine();
		return r;
	}
	public static void out(String s) {
		System.out.print("\n" + s);
	}
}
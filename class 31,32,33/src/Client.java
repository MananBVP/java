import org.omg.PortableServer.LIFESPAN_POLICY_ID;

public class Client {

	public static void main(String[] args) {
		Linked_List list=new Linked_List();
		
//		list.addLast(10);
//		list.addLast(20);
//		list.addLast(30);
//		list.dispaly();
//		list.addFirst(50);
//		list.dispaly();
//		System.out.println(list.getAt(2));
//		System.out.println(list.getFirst());
//		System.out.println(list.getLast());
//		list.dispaly();
//		System.out.println(list.removeFirst());
//		System.out.println(list.removeLast());
//		System.out.println(list.removeAt(1));
//		list.addAt(1, 20);
//		list.dispaly();
		
//		list.addFirst(10);
//		list.dispaly();
//		list.addLast(20);
//		list.dispaly();
//		list.addLast(30);
//		list.dispaly();
//		list.addFirst(40);
//		list.dispaly();
//		list.addAt(2, 100);
//		list.dispaly();
//		System.out.println(list.removeAt(3));
//		list.dispaly();
//		list.reverseDI();
//		list.dispaly();
//		list.reversePI();
//		list.dispaly();
//		while(!list.isEmpty()) {
//			System.out.println(list.removeLast());
//			list.dispaly();
//		}
//		list.addLast(10);
//		list.addLast(20);
//		list.addLast(30);
//		list.addLast(40);
//		list.addLast(50);
//		list.addLast(60);
//		list.addLast(70);
//		System.out.println(list.isPalindrome());
//		list.fold();
//		list.dispaly();
//		System.out.println(list.mid());
//		System.out.println(list.kthFromLast(1));
//		list.dispaly();
		Linked_List l1=new Linked_List();
		Linked_List l2=new Linked_List();
		l1.addLast(10);
		l1.addLast(15);
		l1.addLast(20);
		l1.addLast(25);
		l1.addLast(30);
		l1.addLast(35);
		
		l2.addLast(12);
		l2.addLast(45);
		l2.addLast(50);
		l2.addLast(55);
		l2.addLast(60);
//		Linked_List newlist=new Linked_List().mergeTwoSortedLists(l1, l2);
//		newlist.dispaly();
		
		Linked_List new1=Linked_List.mergesort(l1);
		new1.dispaly();
		l1.kReverse(3);
		l1.dispaly();
		
	}

}

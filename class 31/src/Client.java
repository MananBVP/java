
public class Client {

	public static void main(String[] args) {
		Linked_List list=new Linked_List();
		
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
//		list.dispaly();
		list.addFirst(50);
//		list.dispaly();
		System.out.println(list.getAt(2));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		list.dispaly();
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
		System.out.println(list.removeAt(1));
		list.dispaly();
	}

}

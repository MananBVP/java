
public class client_queue {

	public static void main(String[] args) {
		Queue q=new Queue(5);
		q.enQueue(10);
		q.dispaly();
		q.enQueue(20);
		q.dispaly();
		q.enQueue(30);
		q.dispaly();
		q.enQueue(40);
		q.dispaly();
	
		System.out.println(q.front()+" "+q.deQueue());
		q.dispaly();
		System.out.println(q.front()+" "+q.deQueue());
		q.dispaly();
		q.enQueue(50);
		q.dispaly();
		q.enQueue(60);
		q.dispaly();
		q.enQueue(70);
		q.dispaly();
		q.enQueue(80);
		q.dispaly();
		System.out.println(q.front()+" "+q.deQueue());
		q.dispaly();
		System.out.println(q.front()+" "+q.deQueue());
		q.dispaly();
		System.out.println(q.front()+" "+q.deQueue());
		q.dispaly();
		System.out.println(q.front()+" "+q.deQueue());
		q.dispaly();
		System.out.println(q.front()+" "+q.deQueue());
		q.dispaly();
		System.out.println(q.front()+" "+q.deQueue());
		q.dispaly();
	}

}

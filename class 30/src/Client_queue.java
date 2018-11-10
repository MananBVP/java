
public class Client_queue {

	public static void main(String[] args) {
		dynamic_queue obj=new dynamic_queue(5);
		obj.enQueue(10);
		obj.enQueue(20);
		obj.enQueue(30);
		obj.enQueue(40);
		obj.deQueue();
		obj.deQueue();
		obj.enQueue(50);
		obj.enQueue(60);
		obj.enQueue(70);
		obj.enQueue(80);
		obj.dispaly();
		queuetostack();
	}
	private static void queuetostack() {
		QueueToStack qs=new QueueToStack(5);
		qs.push(10);
		qs.push(20);
		qs.push(30);
		qs.push(40);
		System.out.println(qs.top()+" "+qs.pop());
		System.out.println(qs.top()+" "+qs.pop());
		System.out.println(qs.top()+" "+qs.pop());
		System.out.println(qs.top()+" "+qs.pop());
		
	}
	
}

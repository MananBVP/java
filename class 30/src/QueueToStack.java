// pop and top efficient i.e. in O(1) and push in O(n)
public class QueueToStack { 
	private dynamic_queue dq;
	private dynamic_queue hq;
	
	public QueueToStack(int cap) {
		dq=new dynamic_queue(cap);
		hq=new dynamic_queue(cap);
	}
	public void push(int val) {
		hq.enQueue(val);
		while(dq.size()>0) {
			hq.enQueue(dq.deQueue());
		}
		dynamic_queue temp=dq;
		dq=hq;
		hq=temp;
	}
	public int pop() {
		return dq.deQueue();
	}
	public int top() {
		return dq.front();
	}
}

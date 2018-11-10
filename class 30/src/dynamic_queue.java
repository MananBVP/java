
public class dynamic_queue extends Queue {
	public dynamic_queue(int cap) {
		super(cap);		
	}
	public void enQueue(int val) {
		if (size == arr.length) {
			int[] oa=arr;
			arr=new int[2*oa.length];
			for(int i=0;i<oa.length;i++) {
				arr[i]=oa[(i+front)%oa.length];
			}
			front=0;
		}
		super.enQueue(val);
	}
}

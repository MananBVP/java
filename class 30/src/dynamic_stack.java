
public class dynamic_stack extends stack {
	
	public dynamic_stack(int cap) {
		super(cap);
	}
	public void push(int val) {
		if (tos == arr.length - 1) {
			int[] oa=arr;
			arr=new int[2*oa.length];
			for(int i=0;i<oa.length;i++) {
				arr[i]=oa[i];
			}
		}
		super.push(val);
	}

}

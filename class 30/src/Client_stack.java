
public class Client_stack {

	public static void main(String[] args) {
		dynamic_stack obj=new dynamic_stack(5);
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(40);
		obj.push(50);
		obj.push(60);
		obj.push(70);
		obj.push(80);
		obj.push(90);
		obj.display();
		twostack();
	}
	public static void twostack() {
		TwoStacks ts=new TwoStacks(5);
		ts.push1(10);
		ts.push1(20);
		ts.push1(30);
		ts.push2(40);
		ts.push2(50);
		ts.push2(60);
		System.out.println(ts.pop1());
		System.out.println(ts.pop2());
		
		System.out.println(ts.top1());
		System.out.println(ts.top2());
	}
}

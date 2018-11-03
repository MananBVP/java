
public class client_stack {

	public static void main(String[] args) {
		stack st=new stack(5);
		
		st.push(10);
		st.display();
		st.push(20);
		st.display();
		st.push(30);
		st.display();
		st.push(40);
		st.display();
		st.push(50);
		st.display();
		st.push(60);
		st.display();
		System.out.println(st.top()+" "+st.pop());
		st.display();
		System.out.println(st.top()+" "+st.pop());
		st.display();
		System.out.println(st.top()+" "+st.pop());
		st.display();
		System.out.println(st.top()+" "+st.pop());
		st.display();
		System.out.println(st.top()+" "+st.pop());
		st.display();
		System.out.println(st.top()+" "+st.pop());
		st.display();
	}
}

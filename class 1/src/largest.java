public class largest {

	public static void main(String[] args) {
    int a=40;
    int b=50;
    int c=60;
//    if(a>=b && a>=c) {
//    	System.out.println(a+ "is largest");
//    }
//    if(b>=a && b>=c) {
//    	System.out.println(b+ "is largest");
//    }
//    System.out.println(c+ "is largest");
    if(a>=b) {
    	if(a>=c) {
    		System.out.println(a+ "is largest");
    	}
    	else {
        	System.out.println(c+ "is largest");
        	}
    }
    
	else{
		if(b>=c) {
			System.out.println(b+ "is largest");
		}
		else {
			System.out.println(c+ "is largest");
			}
		}
	}
}

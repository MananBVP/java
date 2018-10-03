import java.util.ArrayList;

public class recursionmem {

	public static void main(String[] args) {
      int[] arr= {10,20,30,40,50,60,70};
//      printTargetSubset(arr, 0, 50, "", 0);
//      printTargetSubsets(arr, 0, 50,new ArrayList<Integer>(), 0);
      printEquiset(arr, 0,new ArrayList<Integer>(),new ArrayList<Integer>(), 0, 0);
      
	}

	private static void printTargetSubset(int[] arr,int vidx,int sum,String set,int sos) {
		if(vidx==arr.length) {
			if(sos==sum) {
				System.out.println(set);
				return;
			}
        	return;
        }
		printTargetSubset(arr, vidx+1, sum, set+arr[vidx]+" ", sos+arr[vidx]);
		printTargetSubset(arr, vidx+1, sum, set, sos);	
	}
	private static void printTargetSubsets(int[] arr,int vidx,int sum,ArrayList<Integer> set,int sos) {
		if(vidx==arr.length) {
			if(sos==sum) {
				System.out.println(set);
				return;
			}
        	return;
        }
		set.add(arr[vidx]);
		printTargetSubsets(arr, vidx+1, sum, set, sos+arr[vidx]);
		set.remove(set.size()-1);
		printTargetSubsets(arr, vidx+1, sum, set, sos);
		
	}
	private static void printEquiset(int[] arr,int vidx,ArrayList<Integer>set1,ArrayList<Integer>set2,int sos1,int sos2) {
		if(vidx==arr.length) {
			if(sos1==sos2) {
				System.out.println(set1+" "+set2);
			}
        return;
		}
        	set1.add(arr[vidx]);
    		printEquiset(arr, vidx+1, set1, set2, sos1+arr[vidx], sos2);    
    		set1.remove(set1.size()-1);
    		set2.add(arr[vidx]);
    		printEquiset(arr, vidx+1, set1, set2, sos1, sos2+arr[vidx]);
    		set2.remove(set2.size()-1);	
		}
	}


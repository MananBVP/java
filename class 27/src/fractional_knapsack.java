import java.util.Arrays;

public class fractional_knapsack {

	public static void main(String[] args) {
		int[] weights= {10,40,20,30};
		int[] values= {60,40,100,120};
		fractionalKnapsack(weights, values, 50);
		
	}
	private static void fractionalKnapsack(int[] wts,int[] vals,int cap) {
		Item[] items=new Item[wts.length];
		for(int i=0;i<items.length;i++) {
			items[i]=new Item();
			items[i].weight=wts[i];
			items[i].value=vals[i];
			items[i].vwratio=vals[i]*1.0/wts[i];
			}
		Arrays.sort(items);
		int i=wts.length-1;
		int rc=cap;
		int vib=0;
		while(rc>0) {
			if(rc>=items[i].weight) {
				rc-=items[i].weight;
				vib+=items[i].value;
				i--;
			}else {
				vib+=items[i].value*rc/items[i].weight;
				rc=0;
			}
		}
		System.out.println(vib);
	}
}

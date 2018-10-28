
public class Item implements Comparable<Item>{
	int weight;
	int value;
	double vwratio;
	
	@Override
	public int compareTo(Item o) {
		if(this.vwratio<o.vwratio) {
			return -1;
		}else if(this.vwratio>o.vwratio) {
			return +1;
		}else {
			return 0;
		}
	}
}

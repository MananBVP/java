import java.util.ArrayList;

public class Hash_Map<K, V> {
	
	private class HMNode{
		K key;
		V value;
		
		public HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	Linked_List<HMNode>[] buckets;
	int size = 0;
	
	@SuppressWarnings("unchecked")
	public Hash_Map() {
		buckets = new Linked_List[4];
		for(int i = 0; i<buckets.length; i++) {
			buckets[i] = new Linked_List<>();
		}
	}
	
	public boolean containsKey(K key) {
		
	}
	
	public V get(K key) {
		
	}
	
	public V remove(K key) {
		
	}
	
	public void put(K key , V value) {
		
	}
	
	public ArrayList<K> keySet(){
		
	}
	
	public int size() {
		
	}
	
	public boolean isEmpty() {
		
	}
	
	public void display() {
		
	}
}

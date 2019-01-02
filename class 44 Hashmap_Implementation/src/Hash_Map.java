import java.util.ArrayList;

public class Hash_Map<K, V> {

	private class HMNode {
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
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Linked_List<>();
		}
	}

	public boolean containsKey(K key) {
		int bi = hashFunction(key);
		HMNode hmnode = findWithinBuckets(bi, key);

		if (hmnode == null) {
			return false;
		} else {
			return true;
		}
	}

	public V get(K key) {
		int bi = hashFunction(key);
		HMNode hmnode = findWithinBuckets(bi, key);

		if (hmnode == null) {
			return null;
		} else {
			return hmnode.value;
		}
	}

	public V remove(K key) {
		int bi = hashFunction(key);
		HMNode hmnode = findWithinBuckets(bi, key);

		if (hmnode == null) {
			return null;
		} else {
			removeFromBuckets(bi, key);
			size--;
			return hmnode.value;
		}
	}

	public void put(K key, V value) {
		int bi = hashFunction(key);
		HMNode hmnode = findWithinBuckets(bi, key);

		if (hmnode == null) {
			hmnode = new HMNode(key, value);
			buckets[bi].addLast(hmnode);
			size++;
		} else {
			hmnode.value = value;
		}

		double lambda = size * 1.0 / buckets.length;
		if (lambda > 2.0) {
			rehash();
		}
	}

	public ArrayList<K> keySet() {
		ArrayList<K> list = new ArrayList<>();
		for (int bi = 0; bi < buckets.length; bi++) {
			for (int di = 0; di < buckets[bi].size; di++) {
				HMNode hmnode = buckets[bi].getAt(di);
				list.add(hmnode.key);
			}
		}

		return list;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void display() {
		System.out.println("------------------");
		for (int bi = 0; bi < buckets.length; bi++) {
			System.out.print("B" + bi + " ");
			for (int di = 0; di < buckets[bi].size; di++) {
				HMNode hmnode = buckets[bi].getAt(di);
				System.out.print("[" + hmnode.key + "_" + hmnode.value + "]");
				
			}
			System.out.println(".");
		}
		System.out.println("-------------------");
	}

	private int hashFunction(K key) {
		int hc = key.hashCode();

		return Math.abs(hc) % buckets.length;
	}

	private HMNode findWithinBuckets(int bi, K key) {
		for (int di = 0; di < buckets[bi].size; di++) {
			HMNode hmnode = buckets[bi].getAt(di);
			if (hmnode.key.equals(key)) {
				return hmnode;
			}
		}

		return null;
	}

	private void removeFromBuckets(int bi, K key) {
		for (int di = 0; di < buckets[bi].size; di++) {
			HMNode hmnode = buckets[bi].getAt(di);
			if (hmnode.key.equals(key)) {
				buckets[bi].removeAt(di);
				return;
			}
		}
	}

	private void rehash() {
		Linked_List<HMNode>[] oba = buckets;

		buckets = new Linked_List[2 * buckets.length];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Linked_List<>();
		}

		
		HMNode hmnode;
		size = 0;
		for (int bi = 0; bi < oba.length; bi++) {
			for (int di = 0; di < oba[bi].size; di++) {
				hmnode = oba[bi].getAt(di);
				put(hmnode.key, hmnode.value);
			}
		}
	}
}

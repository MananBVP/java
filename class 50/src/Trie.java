import java.util.HashMap;

public class Trie {
	private class Node {
		Character data;
		HashMap<Character, Node> children = new HashMap<>();
		boolean eow; // end of word

		public String toString() {
			return eow ? data + "*" : data + "";
		}
	}

	private Node root;
	private int words;
	private int nodes;

	public Trie() {
		root = new Node();
		root.data = '$';
	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {
		if (word.length() == 0) {
			return node.eow;
		}
		Character ch = word.charAt(0);
		String res = word.substring(1);

		if (node.children.get(ch) != null) {
			return searchWord(node.children.get(ch), res);
		} else {
			return false;
		}

	}

	public void addWord(String word) {
		if (searchWord(word) == false) {
			addWord(root, word);
		}
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = true;
			words++;
			return;
		}

		Character ch = word.charAt(0);
		String res = word.substring(1);

		if (node.children.get(ch) != null) {
			addWord(node.children.get(ch), res);
		} else {
			nodes++;
			Node nd = new Node();
			nd.data = ch;
			node.children.put(ch, nd);
			addWord(nd, res);
		}
	}

	public void removeWord(String word) {
		if (searchWord(word) == true) {
			removeWord(root, word);
		}
	}

	private void removeWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = false;
			words--;
			return;
		}

		Character ch = word.charAt(0);
		String res = word.substring(1);

		Node child = node.children.get(ch);
		removeWord(child, res);

		if (child.eow == false && child.children.size() == 0) {
			node.children.remove(ch);
			nodes--;
		}
	}

	public void displayAllWords() {
		displayAllWords(root, " ");
	}

	private void displayAllWords(Node node, String asf) {

		if (node.eow == true) {
			System.out.print(asf + " ");
		}

		for (Character n : node.children.keySet()) {
			displayAllWords(node.children.get(n), asf + n);
		}
	}

	public void displayTrie() {
		displayTrie(root, " ");
	}

	private void displayTrie(Node node, String asf) {

		System.out.println(node.data + " -> " + node.children);

		for (Character n : node.children.keySet()) {
			displayTrie(node.children.get(n), asf + n);
		}
	}
}
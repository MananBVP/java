
public class Client {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("are");
		trie.addWord("art");
		trie.addWord("an");
		trie.addWord("and");
		trie.addWord("ant");
		trie.addWord("as");
		trie.addWord("ask");
		trie.addWord("see");
		trie.addWord("sea");
		trie.addWord("seen");
		
		System.out.println(trie.searchWord("an") + " " + trie.searchWord("ant") + " " + trie.searchWord("as") + " " + trie.searchWord("ask"));
		
		trie.removeWord("an");
		System.out.println(trie.searchWord("an") + " " + trie.searchWord("ant") + " " + trie.searchWord("as") + " " + trie.searchWord("ask"));
		
		trie.removeWord("ant");
		System.out.println(trie.searchWord("an") + " " + trie.searchWord("ant") + " " + trie.searchWord("as") + " " + trie.searchWord("ask"));
		
		trie.removeWord("ask");
		System.out.println(trie.searchWord("an") + " " + trie.searchWord("ant") + " " + trie.searchWord("as") + " " + trie.searchWord("ask"));
		
		trie.removeWord("as");
		System.out.println(trie.searchWord("an") + " " + trie.searchWord("ant") + " " + trie.searchWord("as") + " " + trie.searchWord("ask"));
		
		trie.displayAllWords();
		
		trie.displayTrie();
	}

}

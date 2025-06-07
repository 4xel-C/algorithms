package DataStructure;
import java.util.Queue;
import java.util.LinkedList;

// Implementation of a trie using the 26 letters of the alphabet (all lowercase).
public class Trie {

    private Node root;
    int R = 26; // 26 letters of the alphabet.

    private class Node {
        boolean value;
        Node[] next;

        private Node() {
            this.value = false;
            this.next = new Node[26];
        }
    }

    // Trie initialization.
    public Trie() {
        this.root = new Node();
    }

    // Insert a string in the trie.
    public void insert(String string) {
        root = insert(string, root, 0);
    }

    private Node insert(String string, Node node, int d) {
        if (node == null) node = new Node();

        if (d == string.length()) {
            node.value = true;
            return node;
        }

        int index = string.charAt(d) - 97; // 0 indexed.
        node.next[index] = insert(string, node.next[index], d+1);
        return node;
    }


    /**
     * Method to get the final node of a specific String.
     * @param string
     * @return
     */
    public Node get(String string) {
        Node cursor = root;
        int n = string.length();

        for (int i = 0; i < n; i++) {
            if (cursor == null) return null;
            int index = string.charAt(i) - 97;
            cursor = cursor.next[index];
        }
        
        return cursor;
    }

    /**
     * Method to check if a value is in the trie.
     * @param string
     * @return
     */
    public boolean inTrie(String string) {
        Node node = get(string);
        if (node != null) return node.value;
        return false;
    }
    

    /**
     * Delete the corresponding value from the trie.
     * @param string
     */
    public void delete(String string) {
        Node node = get(string);
        if (node != null) node.value = false;
    }


    /**
     * Return an iterable of all the words in order.
     * @return
     */
    public Iterable<String> inOrder() {
        Queue<String> result = new LinkedList<>();

        collect(root, "", result);

        return result;
    }

    // Collect inOrder all the words in the trie.
    private void collect(Node node, String prefix, Queue<String> result) {
        if (node == null) return;

        if (node.value) result.add(prefix);

        // Iterate through all the letters in the word starting for the first to the last.
        for (int i = 0; i < R; i++) {
            char character = (char) (i + 97);
            collect(node.next[i], (String) prefix + character, result);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("bonjour");
        trie.insert("pardon");
        trie.insert("pardonner");

        System.out.println(trie.inTrie("bonjour"));
        System.out.println(trie.inTrie("sdflkjh"));
        trie.delete("bonjour");
        System.out.println(trie.inTrie("bonjour"));
        trie.insert("bonjour");
        trie.insert("aaaa");
        trie.insert("abaa");

        Iterable<String> inorder = trie.inOrder();

        for (String word : inorder) {
            System.out.println(word);
        }

    }
}
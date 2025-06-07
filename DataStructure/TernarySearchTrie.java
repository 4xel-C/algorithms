package DataStructure;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Implementation of a ternary search Trie. Complexity of O(L x log n), but less memory usage compare to a classic Trie.
 */
public class TernarySearchTrie{ 

    private class Node {
        private boolean word = false;
        private char character;
        private Node left, mid, right;
    }

    private Node root;


    /**
     * Method to put a string into the ternary search trie.
     * @param string
     */
    public void put(String string) {
        root = put(string, root, 0);
    }

    private Node put(String string, Node node, int d) {
        
        char c = string.charAt(d);
        
        if (node == null) {
            node = new Node();
            node.character = c;
        }
        

        if (c < node.character) node.left = put(string, node.left, d);
        else if (c > node.character) node.right = put(string, node.right, d);
        else if (d < string.length() - 1) node.mid = put(string, node.mid, d+1); // If we find the right node matching the character, insert the next character in the mid pointer.
        
        // if we reach the right node at the end of the string: flag the word to true
        else {
            node.word = true;
        }

        return node;
    }

    /**
     * Method to get the last node confirming the presence of a specific node. Return null if no find.
     * @param string
     * @return
     */
    public Node get(String string) {
        Node cursor = root;

        int d = 0; // Character counter
        char c;

        while( cursor != null && d < string.length() - 1) {
            c = string.charAt(d);
            if (c < cursor.character) {
                cursor = cursor.left;
            } else if (c > cursor.character) {
                cursor = cursor.right;
            } else {
                cursor = cursor.mid;
                d++;
            }
        }

        if (cursor == null || !cursor.word) return null;  
        return cursor;
    }

    public boolean contain(String string) {
        return get(string) != null;
    }


    public void delete(String string) {
        Node node = get(string);

        if (node != null) node.word = false;
    }


    /**
     * Inorder impression of the ternary search trie.
     * @return
     */
    public Iterable<String> inOrder() {
        Queue<String> result = new LinkedList<>();
        collect(root, "", result);

        return result;
    }


    private void collect(Node node, String prefix, Queue<String> result) {
        if (node == null) return;

        collect(node.left, prefix, result);
        if (node.word) result.add(prefix + node.character);
        collect(node.mid, prefix + node.character, result);
        collect(node.right, prefix, result);
    }




    /**
     * unit testing.
     * @param args
     */
    public static void main(String[] args) {
        
        TernarySearchTrie trie = new TernarySearchTrie();

        trie.put("hello");
        trie.put("hamburger");
        trie.put("history");
        trie.put("ancient");
        trie.put("xylophone");
        trie.put("state");

        trie.delete("hello");

        System.out.println(trie.contain("hello"));
        System.out.println(trie.contain("hamburger"));

        Iterable<String> inorder = trie.inOrder();

        for (String word : inorder) {
            System.out.println(word);
        }
    }

}
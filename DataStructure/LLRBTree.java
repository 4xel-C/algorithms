package DataStructure;

/**
 * Implementation of left leaning red black binary tree (2-3 tree optimization). Can serve as a data structure for Symbol tables, inserting data into the node class.
 */
public class LLRBTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    Node root;

    private class Node {
        int key;
        Node left;
        Node right;
        boolean color;

        public Node(int key)  {
            this.key = key;
            color = RED;
        }
    }

    // ---------------------------------------------- Method to detect if the node is red linked.
    private Boolean isRed(Node node) {
        if (node == null) return false;
        return node.color;
    }

    // ---------------------------------------------- Method to rotate a Node to avoid LLRB Tree violation.
    private Node rotateLeft(Node node) {
        assert isRed(node.right);

        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        return right;
    }

    private Node rotateRight(Node node) {
        assert isRed(node.left);

        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;

        return left;
    }

    // ---------------------------------------------- Method to flip the color of the arc.
    private Node flipColor(Node node) {
        assert isRed(node.left);
        assert isRed(node.right);

        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;

        return node;
    }

    // ---------------------------------------------- Insertion method

    public void insert(int value) {
        root = insert(value, root);
    }

    public Node insert(int value, Node node) {

        if (node == null) return new Node(value);

        if (value < node.key) {
            node.left = insert(value, node.left);
        } else if (value > node.key) {
            node.right = insert(value, node.right);
        } else {
            return node;
        }

        // Ensure the LLRBTree properties are not violated.
        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.right) && isRed(node.left)) node = flipColor(node);

        return node;
    }

    // ---------------------------------------------- Inorder traversal
    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.println("Color: " + (node.color == RED ? "red" : "black") + " Value: " + node.key);
        inOrder(node.right);
    }

    public static void main(String[] args) {

        LLRBTree tree = new LLRBTree();

        tree.insert(5);
        tree.insert(6);
        tree.insert(8);
        tree.insert(1);
        tree.insert(2);
        tree.insert(14);
        tree.insert(13);
        tree.insert(23);
        tree.insert(2322);
        tree.insert(24);
        tree.insert(41);

        tree.inOrder();
    }
}
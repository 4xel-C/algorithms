package DataStructure;

public class AVLBinarySearchTree {

    /**
     * Inner node for tree
     */
    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    
    Node root; // root of the tree
    
    // Constructor
    public AVLBinarySearchTree() {
        root = null;
    }

    public void insert(int element) {
        root = insert(element, root);
    }

    private Node insert(int element, Node node) {

        // if we reach a null node -> create the node at that position
        if (node == null) return new Node(element);

        if (element < node.value) {
            node.left = insert(element, node.left);

        } else if (element > node.value) {
            node.right = insert(element, node.right);
        }
        return node;
    }

    public void delete(int element) {
        root = delete(element, root);
    }

    private Node delete(int element, Node node) {

        // If reach the end of the tring without a find, return the node.
        if (node == null) return node;

        // If node is found delete it depending of his child
        if (element == node.value) {

            // if no childs, delete the node
            if (node.left == null && node.right == null) {
                return null;

            // if only 1 child, return the child
            } else if (node.left == null){
                return node.right;
            } else if (node.right == null) {
                return node.left;

            // if 2 childs -> return the max of the left tree or the min of the right tree
            } else {
                int max = max(node);
                node.value = max;
                node.left = delete(max, node.left);
                return node;
            }
        }

        if (element < node.value) {
            return delete(element, node.left);
        } else {
            return delete(element, node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // Give the max of the tree
    public int max() {
        return max(root);
    }

    // give the max of a node
    private int max(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    public static void main(String[] args) {

        AVLBinarySearchTree tree = new AVLBinarySearchTree();
        tree.insert(10);
        tree.insert(8);
        tree.insert(12);
        tree.preOrder();

    }

    
}

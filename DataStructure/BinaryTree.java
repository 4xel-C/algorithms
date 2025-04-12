package DataStructure;

public class BinaryTree {

    // Inner Node class
    private class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public BinaryTree() {
        this.root = null;
    }

    // ---------------------------------------------------------------------- Insertion method
    /**
     * Recursive insertion method
     * Overload with the node into parameter to traverse through the correct node to add
     */
    private Node insert(Node node, int value) {

        // If we reach a null root, position free -> add a new node.
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;

    }

    // overload the method so the user can pass the value
    public void insert(int value) {
        root = insert(root, value);
    }

// ---------------------------------------------------------------------- Alternative insertion method
    // /**
    //  * Iterative insertion method
    //  */
    // public void insert(int value) {
    //     if (root == null) {
    //         root = new Node(value);  
    //         return;
    //     } 

    //     Node cursor = root;
    //     Node parent = null;

    //     // Traverse until the end of the tree
    //     while (cursor != null) {
    //         parent = cursor;
    //         if (value < cursor.value) {
    //             cursor = cursor.left;
    //         } else {
    //             cursor = cursor.right;
    //         }
    //     }
        
    //     // Use the parent to attach the right or the left
    //     if (value < parent.value) {
    //         parent.left = new Node(value);
    //     } else {
    //         parent.right = new Node(value);
    //     }
    // }
// ---------------------------------------------------------------------- inOrder traversal

    // In order traversal: Left -> Root -> Right
    // Overload to make the method calling easier
    public void inOrder() {
        inOrder(root);
    }
    
    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }

// ---------------------------------------------------------------------- preOrder traversal
    /**
     * preOrder traversal: root -> left -> right
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }


// ---------------------------------------------------------------------- postOrder traversal
    /**
     * postOrder traversal: left -> right -> root
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }

// ---------------------------------------------------------------------- Search method
    // Overload the method to simplify the request
    public boolean search(int value) {
        return search(root, value);
    }

    public boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (node.value == value)  {
            return true;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }


// ---------------------------------------------------------------------- Height of the tree (strating at 0)
    public int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Overcharge for calling simplicity
    public int height() {
        return height(root);
    }

    // Using main as testing method
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);
        tree.insert(12);
        tree.insert(10);

        System.out.println(tree.search(13));
        System.out.println(tree.height());

    }

}
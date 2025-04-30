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
    
    // --------------------------------------------------------------- Constructor
    public AVLBinarySearchTree() {
        root = null;
    }

    // ------------------------------------------------------------ Preorder display
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

        // ------------------------------------------------------------ Postorder display
        public void postOrder() {
            postOrder(root);
        }
    
        private void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }

        
        // ------------------------------------------------------------ inOrder display
        public void inOrder() {
            inOrder(root);
        }
    
        private void inOrder(Node node) {
            if (node == null) return;
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }

    // ------------------------------------------------------------ Height calculation
    public int height() {
        return height(root);
    }

    private int height(Node node) {

        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // ------------------------------------------------------------ Maximum calculation
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

    // ------------------------------------------------------------ Balancing methods
    // rotation on right method
    private Node ror(Node node) {
        
        // If no node on left, do nothing
        if (node == null  || node.left == null) return node;
        
        // if node on left -> make it the new root 
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        
        return leftChild;
    }
    
    // rotation on left method
    private Node rol(Node node) {
        
        // If no node on right, do nothing
        if (node == null  || node.right == null) return node;
        
        // if node on right -> make it the new root 
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        return rightChild;
    }
    
    private int balanceFactor(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private Node balanceNode(Node node) {
        if (node == null) return node;
        
        // if the tree is left heavy
        if (balanceFactor(node) > 1) {

            // if the left child is right heavy
            if (balanceFactor(node.left) < 0) {
                node.left = rol(node.left);
            }

            node = ror(node);

        // if the tree if right heavy
        } else if (balanceFactor(node) < -1) {

            // check if the rightNode if left heay
            if (balanceFactor(node.right) > 0) {
                node.right = ror(node.right);
            }

            node = rol(node);
        }
        return node;
    }

    // ------------------------------------------------------------ Insertion
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
        return balanceNode(node);
    }

    public void delete(int element) {
        root = delete(element, root);
    }

    // ------------------------------------------------------------ Deletion
    private Node delete(int element, Node node) {

        // If reach the end of the tree without a find, return the node.
        if (node == null) return node;

        // If node is found delete it depending of his child
        if (element == node.value) {

            // if no children, delete the node
            if (node.left == null && node.right == null) {
                return null;

            // if only 1 child, return the child
            } else if (node.left == null){
                return node.right;
            } else if (node.right == null) {
                return node.left;

            // if 2 children -> return the max of the left tree or the min of the right tree
            } else {
                int max = max(node.left);
                node.value = max;
                node.left = delete(max, node.left);
                return balanceNode(node);
            }
        }

        if (element < node.value) {
            node.left = delete(element, node.left);
        } else {
            node.right = delete(element, node.right);
        }

        return balanceNode(node);
    }

        // ------------------------------------------------------------ Search
        public boolean search(int element) {
            return search(element, root);
        }

        private boolean search(int element, Node node) {

            // Base case
            if (node == null) return false;
            if (node.value == element) return true;

            if (element < node.value) return search(element, node.left);
            else return search(element, node.right);
        }

    public static void main(String[] args) {
    
        AVLBinarySearchTree tree = new AVLBinarySearchTree();
        tree.insert(10);
        tree.insert(8);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(11);
        tree.preOrder();
        System.out.println(tree.search(12));
        tree.delete(14);
        tree.delete(13);
        tree.preOrder();
    }
}

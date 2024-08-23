public class inorderPredecessor {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public static Node buildTree(int nodes[]) {
        idx++;

        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public static Node inorderPredecessor(Node root, int x) {
        Node predecessor = null;

        while (root != null) {
            if (root.data >= x) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {
        inorderPredecessor tree = new inorderPredecessor();
        int nodes[] = { 15, 10, 8, -1, -1, 12, -1, -1, 20, 16, -1, -1, 25, -1, -1 };
        Node root = tree.buildTree(nodes);
        Node predecessor = inorderPredecessor(root, 20);
        System.out.println(predecessor.data);
    }
}

public class inorderSuccessor {
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

    public static Node inorderSuccessor(Node root, int x) {
        Node Successor = null;

        while (root != null) {
            if (root.data <= x) {
                root = root.right;
            } else {
                Successor = root;
                root = root.left;
            }
        }
        return Successor;
    }

    public static void main(String[] args) {
        inorderSuccessor tree = new inorderSuccessor();
        int nodes[] = { 15, 10, 8, -1, -1, 12, -1, -1, 20, 16, -1, -1, 25, -1, -1 };
        Node root = tree.buildTree(nodes);
        Node successor = inorderSuccessor(root, 20);
        System.out.println(successor.data);
    }
}

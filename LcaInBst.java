public class LcaInBst {
    public static class Node {
        int data;
        Node left;
        Node right;
        int hd;

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

    public static Node LCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        int curr = root.data;
        if (curr < n1 && curr < n2) {
            return LCA(root.right, n1, n2);
        }
        if (curr > n1 && curr > n2) {
            return LCA(root.left, n1, n2);
        }

        return root;
    }

    public static void main(String[] args) {
        LcaInBst tree = new LcaInBst();
        int nodes[] = { 5, 4, 3, -1, -1, -1, 6, -1, 7, -1, 8, -1, -1 };
        Node root = tree.buildTree(nodes);
        Node result = LCA(root, 7, 8);
        System.out.println(result.data);
    }
}

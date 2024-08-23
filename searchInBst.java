public class searchInBst {
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
    static int flag = 0;

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

    public static Node searchInBst(Node root, int x) {
        if (root == null || root.data == x) {
            return root;
        } else if (root.data > x) {
            return searchInBst(root.left, x);
        }

        return searchInBst(root.right, x);
    }

    public static void main(String[] args) {
        searchInBst tree = new searchInBst();
        int nodes[] = { 8, 3, 1, -1, -1, 6, 4, -1, -1, 7, -1, -1, 10, -1, 14, 13, -1, -1, -1 };
        Node root = tree.buildTree(nodes);
        Node answer = searchInBst(root, 13);
        if (answer != null) {
            System.out.println("Element found");
        } else {
            System.out.println("Element Not found");
        }
    }
}

public class checkBST {
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

    public static Boolean checkBST(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.data > root.left.data) {
            return checkBST(root.left);
        }

        if (root.right != null && root.data < root.right.data) {
            return checkBST(root.right);
        }

        return false;
    }

    public static void main(String[] args) {
        checkBST tree = new checkBST();
        int nodes[] = { 2, -1, 7, -1, 6, -1, 5, -1, 9, -1, 2, -1, -1 };
        Node root = tree.buildTree(nodes);
        Boolean result = checkBST(root);
        System.out.println(result);
    }
}

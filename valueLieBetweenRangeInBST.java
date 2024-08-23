public class valueLieBetweenRangeInBST {
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

    public static int count(Node root, int l, int h) {
        if (root == null) {
            return 0;
        }

        if (root.data > l && root.data < h) {
            return 1 + count(root.left, l, h) + count(root.right, l, h);
        } else if (root.data < l) {
            return count(root.right, l, h);
        } else {
            return count(root.left, l, h);
        }
    }

    public static void main(String[] args) {
        valueLieBetweenRangeInBST tree = new valueLieBetweenRangeInBST();
        int nodes[] = { 10, 5, 1, -1, -1, -1, 50, 45, -1, -1, 100, -1, -1 };
        Node root = tree.buildTree(nodes);
        System.out.println(count(root, 5, 45));
    }
}

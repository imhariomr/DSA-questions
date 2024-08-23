public class checkSumTree {
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

    public static int sumTree(Node root, int flag) {
        if (root == null) {
            return 0;
        }
        if (flag == -1) {
            return -1;
        }
        int left = sumTree(root.left, flag);
        int right = sumTree(root.right, flag);

        if (left + right != root.data) {
            flag = -1;
        }
        return left + right + root.data;
    }

    public static void main(String[] args) {
        checkSumTree tree = new checkSumTree();
        int nodes[] = { 10, 20, 10, -1, -1, 10, -1, -1, 30, -1, -1 };
        Node root = tree.buildTree(nodes);
        int flag = 0;
        flag = sumTree(root, flag);
        if (flag == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}

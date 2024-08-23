public class checkAllLeafNodesAreSameLevel {
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

    public static int max = -1;
    public static int flag = -1;

    public static void solve(Node root, int h) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (max == -1) {
                max = h;
            } else {
                if (max != h) {
                    flag = 1;
                } else {
                    return;
                }
            }
        }
        solve(root.left, h + 1);
        solve(root.right, h + 1);
    }

    public static void main(String[] args) {
        checkAllLeafNodesAreSameLevel tree = new checkAllLeafNodesAreSameLevel();
        int nodes[] = { 10, 20, 10, -1, -1, 15, -1, -1, 30, -1, -1 };
        Node root = tree.buildTree(nodes);
        solve(root, 0);
        if (flag == -1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
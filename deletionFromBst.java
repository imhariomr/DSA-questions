public class deletionFromBst {
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

    public static int findmax(Node root) {
        if (root.right == null) {
            return root.data;
        }

        return findmax(root.right);
    }

    public static Node deletionFromBst(Node root, int x) {

        if (root == null) {
            return null;
        }

        if (root.data == x) {

            // no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // one child
            if (root.left == null && root.right != null) {
                return root.right;
            }

            if (root.right == null && root.left != null) {
                return root.left;
            }

            // two child
            if (root.left != null && root.right != null) {
                int mini = findmax(root.left);
                root.data = mini;
                deletionFromBst(root.left, mini);
                return root;
            }
        } else if (root.data > x) {
            root.left = deletionFromBst(root.left, x);
        } else {
            root.right = deletionFromBst(root.right, x);
        }

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        deletionFromBst tree = new deletionFromBst();
        int nodes[] = { 5, 2, -1, 4, -1, -1, 6, -1, 7, -1, -1 };
        Node root = tree.buildTree(nodes);
        preOrder(root);
        root = deletionFromBst(root, 5);
        System.out.println("After deletion");
        preOrder(root);
    }
}

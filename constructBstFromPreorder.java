public class constructBstFromPreorder {
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

    static int idx = 0;

    public static Node construct(int preOrder[], int min, int max, int idx[]) {
        if (idx[0] >= preOrder.length) {
            return null;
        }

        if (preOrder[idx[0]] < min || preOrder[idx[0]] > max) {
            return null;
        }

        Node root = new Node(preOrder[idx[0]++]);
        root.left = construct(preOrder, min, root.data, idx);
        root.right = construct(preOrder, root.data, max, idx);

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
        constructBstFromPreorder tree = new constructBstFromPreorder();
        int preOrder[] = { 10, 5, 1, 7, 40, 50 };
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int i[] = { 0 };
        Node root = construct(preOrder, min, max, i);
        preOrder(root);
    }
}

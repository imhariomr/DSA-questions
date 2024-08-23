public class treeDiameter {
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

    public static int treeDiameter(Node root, int max[]) {
        if (root == null) {
            return 0;
        }

        int lh = treeDiameter(root.left, max);
        int rh = treeDiameter(root.right, max);

        max[0] = Math.max(max[0], (lh + rh));
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        treeDiameter tree = new treeDiameter();
        int nodes[] = { 1, 2, -1, -1, 3, 4, 5, 9, -1, -1, -1, -1, 6, -1, 7, -1, 8, -1, -1 };
        Node root = tree.buildTree(nodes);
        int[] max = new int[1];
        treeDiameter(root, max);
        System.out.println(max[0]);
    }
}
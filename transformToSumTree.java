public class transformToSumTree {
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

    public static void transformToSumTree(Node root) {

    }

    public static void main(String[] args) {
        transformToSumTree tree = new transformToSumTree();
        int nodes[] = { 1, 10, 5, -1, -1, -1, -1 };
        Node root = tree.buildTree(nodes);

    }
}

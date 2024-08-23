public class constructTreeFromInorderAndPreorder {
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

    static int preOrderIndex = 0;

    public static int findposition(int inOrder[], int element, int n) {
        for (int i = 0; i < n; i++) {
            if (inOrder[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static Node buildTree(int inOrder[], int preOrder[], int inOrderstart, int inOrderEnd,
            int n) {
        if (inOrderstart > inOrderEnd) {
            return null;
        }
        int element = preOrder[preOrderIndex++];
        Node root = new Node(element);
        int position = findposition(inOrder, element, n);

        root.left = buildTree(inOrder, preOrder, inOrderstart, position - 1, n);
        root.right = buildTree(inOrder, preOrder, position + 1, inOrderEnd, n);

        return root;
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        constructTreeFromInorderAndPreorder tree = new constructTreeFromInorderAndPreorder();
        int n = 4;
        int inorder[] = { 1, 6, 8, 7 };
        int preOrder[] = { 1, 6, 7, 8 };

        Node head = buildTree(inorder, preOrder, 0, n - 1, n);
        postOrder(head);
    }
}

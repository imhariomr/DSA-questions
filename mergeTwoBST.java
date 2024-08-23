import java.util.ArrayList;

public class mergeTwoBST {
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

    public static void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static void mergeTwoArrayList(ArrayList<Integer> list1, ArrayList<Integer> list2,
            ArrayList<Integer> newList) {
        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                newList.add(list1.get(i++));
            } else {
                newList.add(list2.get(j++));
            }
        }

        while (i < list1.size()) {
            newList.add(list1.get(i++));
        }

        while (j < list2.size()) {
            newList.add(list2.get(j++));
        }
    }

    public static Node constructBST(ArrayList<Integer> list, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;

        Node root = new Node(list.get(mid));
        root.left = constructBST(list, s, mid - 1);
        root.right = constructBST(list, mid + 1, e);

        return root;
    }

    public static void main(String[] args) {
        mergeTwoBST tree = new mergeTwoBST();
        int nodes1[] = { 100, 50, 20, -1, -1, 70, -1, -1, 300, -1, -1 };
        int nodes2[] = { 80, 40, -1, -1, 120, -1, -1 };
        Node root1 = tree.buildTree(nodes1);
        idx = -1;
        Node root2 = tree.buildTree(nodes2);
        ArrayList<Integer> list1 = new ArrayList<>();
        inOrder(root1, list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        inOrder(root2, list2);
        ArrayList<Integer> newList = new ArrayList<>();
        mergeTwoArrayList(list1, list2, newList);
        int s = 0;
        int e = newList.size() - 1;
        Node root = constructBST(newList, s, e);
        ArrayList<Integer> list4 = new ArrayList<>();
        inOrder(root, list4);
        System.out.println(list4);
    }
}

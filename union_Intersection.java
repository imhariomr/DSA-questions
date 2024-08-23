import java.util.*;

public class union_Intersection {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the 1st array: ");
        int n = sc.nextInt();
        System.out.println("Enter the Size of the 2nd array: ");
        int m = sc.nextInt();

        int arr1[] = new int[n];
        int arr2[] = new int[m];

        System.out.println("Enter the elements for the 1st array: ");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the elements for the 2nd array: ");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        // UNION
        HashSet<Integer> hs = new HashSet<>();

        for (int i : arr1) {
            hs.add(i);
        }

        for (int i : arr2) {
            hs.add(i);
        }

        System.out.println("The union of two arrays: " + hs.size());

        // INTERSECTION

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : arr1) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        for (int i : arr2) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for (int i : hm.values()) {
            if (i >= 2) {
                count++;
            }
        }

        System.out.println("Intersection of two arrays: " + count);
    }
}

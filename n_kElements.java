import java.util.*;

public class n_kElements {

    public static void findElements(int arr[], int n, int k) {

        ArrayList<Integer> List = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int number = n / k;

        Set<Integer> keys = map.keySet();
        for (int i : keys) {
            int value = map.get(i);
            if (value > number) {
                List.add(i);
            }
        }

        for (int i = 0; i < List.size(); i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the array: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the array: ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value of k :");

        int k = sc.nextInt();
        findElements(arr, n, k);
    }
}
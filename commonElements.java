import java.util.*;

public class commonElements {

    public static ArrayList<Integer> commonElements(int arr1[], int arr2[], int arr3[]) {

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                ans.add(arr1[i]);
                i++;
                j++;
                k++;
            }

            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the 1st array: ");
        int n1 = sc.nextInt();
        System.out.println("Enter the elements of the 1st Array: ");

        int arr1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the length of the 2nd array: ");
        int n2 = sc.nextInt();
        System.out.println("Enter the elements of the 2nd Array: ");

        int arr2[] = new int[n1];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("Enter the length of the 3rd array: ");
        int n3 = sc.nextInt();
        System.out.println("Enter the elements of the 3rd Array: ");

        int arr3[] = new int[n1];
        for (int i = 0; i < n3; i++) {
            arr3[i] = sc.nextInt();
        }

        ArrayList<Integer> ans = commonElements(arr1, arr2, arr3);
        System.out.println(ans);
    }
}

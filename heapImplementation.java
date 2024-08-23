import java.util.*;

public class heapImplementation {

    public static class Maxheap {

        public static int arr[] = new int[100];
        public static int size = 0;

        public static void insert(int data) {
            size = size + 1;
            int index = size;
            arr[size] = data;

            while (index > 1) {
                int parent = (index - 1) / 2;

                if (arr[parent] < arr[index]) {
                    int temp = arr[parent];
                    arr[parent] = arr[index];
                    arr[index] = temp;

                    index = parent;
                } else {
                    return;
                }
            }
        }

        public static void deletion() {

            arr[0] = arr[size - 1];
            size--;

            int i = 0;

            while (i < size) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left <= size && arr[left] > arr[i]) {
                    int temp = arr[left];
                    arr[left] = arr[i];
                    arr[i] = temp;
                    i = left;
                } else if (right <= size && arr[right] > arr[i]) {
                    int temp = arr[right];
                    arr[right] = arr[i];
                    arr[i] = temp;
                    i = right;
                } else {
                    return;
                }
            }
        }

        public static void print() {
            for (int i = 0; i < size; i++) {
                System.out.println(arr[i]);
            }

        }
    }

    public static void main(String[] args) {
        Maxheap heap = new Maxheap();
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.deletion();
        heap.deletion();
        heap.deletion();

        heap.print();
    }
}
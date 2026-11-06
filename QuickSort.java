import java.util.*;

public class QuickSort {

    // Deterministic Quick Sort
    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high]; // Fixed pivot: last element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Randomized Quick Sort
    static int randomizedPartition(int[] arr, int low, int high) {

        Random rand = new Random();

        // Choose a random pivot index
        int randomIndex = low + rand.nextInt(high - low + 1);

        // Swap random pivot with last element
        int temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        // Use normal partition
        return partition(arr, low, high);
    }

    static void randomizedQuickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = randomizedPartition(arr, low, high);

            randomizedQuickSort(arr, low, pi - 1);
            randomizedQuickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {

        int[] arr1 = {8, 3, 1, 7, 0, 10, 2};
        int[] arr2 = arr1.clone();

        // Deterministic Quick Sort
        quickSort(arr1, 0, arr1.length - 1);

        System.out.println("Deterministic Quick Sort:");
        System.out.println(Arrays.toString(arr1));

        // Randomized Quick Sort
        randomizedQuickSort(arr2, 0, arr2.length - 1);

        System.out.println("Randomized Quick Sort:");
        System.out.println(Arrays.toString(arr2));
    }
}
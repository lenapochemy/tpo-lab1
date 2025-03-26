package task2;

public class QuickSort {

    public static Integer[] sort(Integer[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quickSort(Integer[] arr, int l, int r) {
        if (r >= arr.length) throw new IllegalArgumentException("Right index can't be greater than array size");
        if (l < r) {
            int bl = partition(arr, l, r);
            quickSort(arr, l, bl - 1);
            quickSort(arr, bl, r);
        }
    }

    public static int partition(Integer[] arr, int l, int r) {
        if (r >= arr.length) throw new IllegalArgumentException("Right index can't be greater than array size");
        int pivot = arr[l];
        int i = l + 1;
        int j = r;
        while (i != j) {
            if (arr[i] > pivot) {
                while (arr[j] >= pivot && i < j) {
                    j--;
                }
                if (i < j && arr[j] < pivot) {
                    swap(arr, i, j);
                }
                if (i == j) {
                    break;
                }
            }
            i++;
        }
        if (arr[i] < pivot) {
            swap(arr, l, i);
        } else {
            swap(arr, l, i - 1);
        }
        return i;
    }

    public static void swap(Integer[] arr, int i, int j) {
        if (i >= arr.length || j >= arr.length)
            throw new IllegalArgumentException("Index can't be greater than array size");
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

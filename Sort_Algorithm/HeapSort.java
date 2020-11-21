package sort;

/**
 * @Author XuLuo
 * @Description
 * @Date 2020/11/21 3:07 PM
 **/
public class HeapSort {
    public int[] sortArray(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }

        return arr;
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        //l is the index of the left child node
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        //r is the index of the right child node
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

}

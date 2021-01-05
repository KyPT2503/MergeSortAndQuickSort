import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] ints) {
        quickSort(ints, 0, ints.length - 1);
    }

    private static void quickSort(int[] ints, int low, int high) {
        if (low >= high) return;
        int middle = partition(ints, low, high);
        quickSort(ints, low, middle - 1);
        quickSort(ints, middle + 1, high);
    }

    private static int partition(int[] ints, int low, int high) {
        int left = low, right = high - 1;
        while (true) {
            while (left <= right && ints[left] < ints[high]) left++;
            while (right > left && ints[right] >= ints[high]) right--;
            if (left >= right) break;
            //swap left and right, if value of left < value of high and value of right > value of high
            int tmp = ints[left];
            ints[left] = ints[right];
            ints[right] = tmp;

            left++;
            right--;
        }
        //swap value of left and value of high
        int tmp = ints[left];
        ints[left] = ints[high];
        ints[high] = tmp;
        return left;
    }
}

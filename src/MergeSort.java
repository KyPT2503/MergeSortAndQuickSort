import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] ints) {
        mergeSort(ints, 0, ints.length - 1);
    }

    private static void mergeSort(int[] ints, int low, int high) {
        if (low >= high) return;
        int middle = (low + high) / 2;
        mergeSort(ints, low, middle);
        mergeSort(ints, middle + 1, high);
        merge(ints, low, middle, high);
    }

    private static void merge(int[] ints, int low, int middle, int high) {
        int[] firstChildInts = new int[middle - low + 1];
        int[] secondChildInts = new int[high - middle];
        System.arraycopy(ints, low, firstChildInts, 0, firstChildInts.length);
        System.arraycopy(ints, middle + 1, secondChildInts, 0, secondChildInts.length);
        for (int i = low, j = 0, k = 0; i <= high; i++) {
            if (j == firstChildInts.length) return;
            else if (k >= secondChildInts.length) ints[i] = firstChildInts[j++];
            else {
                if (firstChildInts[j] < secondChildInts[k]) ints[i] = firstChildInts[j++];
                else ints[i] = secondChildInts[k++];
            }
        }
    }
}

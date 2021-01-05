import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class QuickSortTest {
    private int[] input;
    private int[] result;

    public QuickSortTest(int[] input) {
        this.input = input;
        this.result = new int[this.input.length];
        System.arraycopy(this.input, 0, this.result, 0, this.result.length);
        Arrays.sort(this.result);
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        int[][] inputs = new int[100][];
        for (int i = 0; i < inputs.length; i++) {
            int length = (int) (Math.random() * 1000000);
            inputs[i] = new int[length];
            for (int j = 0; j < inputs[i].length; j++) {
                inputs[i][j] = (int) ((Math.random() - 0.5) * 2 * Integer.MAX_VALUE);
            }
        }
        return Arrays.asList(inputs);
    }

    @Test
    public void quickSort() {
        QuickSort.quickSort(this.input);
        assertTrue(Arrays.equals(this.input, this.result));
    }
}
/**
 * 2145. 统计隐藏数组数目.
 * medium
 *
 * @author avatarannappa
 * @version 1.1, 2025.4.21
 */
public class NumberOfArrays2145 {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        // 规律
        int count = 0;
        int n = differences.length;

        // 找到形状，即：最大、最小值。diff差太多会溢出，这里用long
        long[] array = new long[n + 1];
        long min = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            array[i + 1] = array[i] + differences[i];
            min = Math.min(array[i + 1], min);
            max = Math.max(array[i + 1], max);
        }

        // 最小位对齐
        long gap = lower - min;
        max = max + gap;
        count = Math.max(count, (int) (upper - max + 1));

        return count;
    }

    public int numberOfArraysOld(int[] differences, int lower, int upper) {
        // 模拟，超时
        int count = 0;

        for (int i = lower; i <= upper; i++) {
            int next = i;
            int j = 0;
            for (; j < differences.length; j++) {
                next = next + differences[j];
                if (next < lower || next > upper) {
                    break;
                }
            }
            if (j == differences.length) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] differences = new int[]{100000, 100000};
        int lower = -100000;
        int upper = 100000;
        System.out.println(new NumberOfArrays2145().numberOfArrays(differences, lower, upper));
    }
}

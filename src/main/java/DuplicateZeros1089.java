import java.util.Arrays;

/**
 * 1089. 复写零
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/6/17
 */
public class DuplicateZeros1089 {

    public void duplicateZeros(int[] arr) {
        // 内存占用比较多。0计数，然后倒叙找位置不想写
        int len = arr.length;
        int[] temp = new int[len];
        for (int i = 0, j = 0; i < len && j < len; i++, j++) {
            temp[j] = arr[i];
            if (arr[i] == 0 && j + 1 < len) {
                temp[j++] = 0;
            }
        }
        System.arraycopy(temp, 0, arr, 0, len);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 4, 5, 0, 0};
        // [1,0,0,2,3,0,0,4]
        new DuplicateZeros1089().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}

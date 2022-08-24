import java.util.Arrays;

/**
 * 1460. 通过翻转子数组使两个数组相等
 * easy
 *
 * @author avatarannappa
 * @date 2022/8/24
 */
public class CanBeEqual1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        // 只要两数组数字出现频率一样，可以通过逐项交换，达到目的。
        int[] count = new int[10010];
        for (int i = 0; i < target.length; i++) {
            count[target[i]]++;
            count[arr[i]]--;
        }
        return Arrays.stream(count).filter(o -> o != 0).count() == 0;
    }

    public static void main(String[] args) {
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 6};
        // true
        System.out.println(new CanBeEqual1460().canBeEqual(target, arr));
    }
}

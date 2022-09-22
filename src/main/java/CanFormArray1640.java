import java.util.HashMap;
import java.util.Map;

/**
 * 1640. 能否连接形成数组
 * easy
 *
 * @author avatarannappa
 * @date 2022/9/22
 */
public class CanFormArray1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int[] temp = map.get(arr[i]);
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] != arr[i + j]) {
                        return false;
                    }
                }
                i = i + temp.length - 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
        // 输出：true
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};
        System.out.println(new CanFormArray1640().canFormArray(arr, pieces));
    }
}

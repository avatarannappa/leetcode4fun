import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1710. 卡车上的最大单元数
 * easy
 *
 * @author avatarannappa
 * @date 2022/11/15
 */
public class MaximumUnits1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 贪心
        int ans = 0;
        List<int[]> list = Arrays.stream(boxTypes).sorted((o1, o2) -> o2[1] - o1[1]).collect(Collectors.toList());
        for (int[] boxType : list) {
            for (int i = 0; i < boxType[0]; i++) {
                truckSize--;
                if (truckSize < 0) {
                    return ans;
                } else {
                    ans += boxType[1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
        // 输出：8
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println(new MaximumUnits1710().maximumUnits(boxTypes, truckSize));
    }
}

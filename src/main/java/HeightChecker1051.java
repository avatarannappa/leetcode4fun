/**
 * 1051. 高度检查器
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/10
 */
public class HeightChecker1051 {

    public int heightChecker(int[] heights) {
        int[] bucket = new int[101];
        for (int height : heights) {
            bucket[height]++;
        }

        int result = 0;

        for (int i = 1, j = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                if (heights[j++] != i) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] heigths = {1, 1, 4, 2, 1, 3};
        System.out.println(new HeightChecker1051().heightChecker(heigths));
    }
}

import java.util.Arrays;

/**
 * 274. H 指数
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/27
 */
public class HIndex274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] citations = {1,3,1};
        System.out.println(new HIndex274().hIndex(citations));
    }
}

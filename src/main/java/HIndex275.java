/**
 * 275. H 指数 II
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/7
 */
public class HIndex275 {

    public int hIndex(int[] citations) {
        // O(logn) 二分
        int left = 0;
        int right = citations.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (citations[mid] > citations.length - mid) {
                right = mid - 1;
            } else if (citations[mid] < citations.length - mid) {
                left = mid + 1;
            } else {
                return citations.length - mid;
            }
        }
        return citations.length - left;
    }

    public static void main(String[] args) {
        int[] citations = {0, 1, 3, 5, 6};
        System.out.println(new HIndex275().hIndex(citations));
    }
}

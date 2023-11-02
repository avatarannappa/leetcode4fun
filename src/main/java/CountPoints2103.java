/**
 * 2103. 环和杆
 * easy
 *
 * @author avatarannappa
 * @date 2023/11/2
 */
public class CountPoints2103 {

    public int countPoints(String rings) {
        int[] arr = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            char c = rings.charAt(i);
            int v = rings.charAt(i + 1) - '0';
            if (c == 'R') {
                arr[v] = (arr[v] & 6) + 1;
            } else if (c == 'G') {
                arr[v] = (arr[v] & 5) + 2;
            } else {
                arr[v] = (arr[v] & 3) + 4;
            }
        }
        int ans = 0;
        for (int i : arr) {
            if (i == 7) {
                ans++;
            }
        }
        return ans;
    }

}

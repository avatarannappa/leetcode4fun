/**
 * 461. 汉明距离.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/13
 */
public class HamingDistance461 {

    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int distance = 0;
        String nStr = Integer.toBinaryString(n);
        for (int i = 0; i < nStr.length(); i++) {
            if (nStr.charAt(i) == '1') {
                distance++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(new HamingDistance461().hammingDistance(x, y));
    }
}

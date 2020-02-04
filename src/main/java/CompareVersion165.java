/**
 * 165. 比较版本号
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/4
 */
public class CompareVersion165 {
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        int maxLength = Math.max(1, Math.max(a1.length, a2.length));
        int[] v1 = new int[maxLength];
        int[] v2 = new int[maxLength];


        for (int i = 0; i < a1.length; i++) {
            String s = a1[i];
            int t = Integer.valueOf(s);
            v1[i] = t;
        }

        for (int i = 0; i < a2.length; i++) {
            String s = a2[i];
            int t = Integer.valueOf(s);
            v2[i] = t;
        }
        for (int i = 0; i < maxLength; i++) {
            if (v1[i] > v2[i]) {
                return 1;
            } else if (v1[i] < v2[i]) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "01";
        String version2 = "1";
        System.out.println(new CompareVersion165().compareVersion(version1, version2));
    }

}

/**
 * 2337. 移动片段得到字符串
 * medium
 *
 * @author avatarannapp
 * @date 2023/8/21
 */
public class CanChange2337 {

    public boolean canChange(String start, String target) {
        // 规律
        if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
            return false;
        }
        int i = 0;
        int j = 0;
        int n = start.length();
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            if ((i < j) && (start.charAt(i) == 'L')) {
                return false;
            } else if ((i > j) && (start.charAt(i) == 'R')) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        String start = "_L__R__R_", target = "L______RR";
        System.out.println(new CanChange2337().canChange(start, target));
    }
}

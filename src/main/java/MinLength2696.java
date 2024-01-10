/**
 * 2696. 删除子串后的字符串最小长度
 * easy
 *
 * @author avatarannappa
 * @date 2024/1/10
 */
public class MinLength2696 {

    public int minLength(String s) {
        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[arr.length];
        int ans = arr.length;
        boolean cont;
        do {
            cont = false;
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i] && (arr[i] == 'A' || arr[i] == 'C')) {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (!visited[j]) {
                            if (((arr[i] == 'A' && arr[j] == 'B') || (arr[i] == 'C' && arr[j] == 'D'))) {
                                visited[i] = true;
                                visited[j] = true;
                                ans -= 2;
                                cont = true;
                            }
                            break;
                        }
                    }
                }
            }
        } while (cont);
        return ans;
    }

    public static void main(String[] args) {
        String s = "CCDAABBDCD";
        // 0
        System.out.println(new MinLength2696().minLength(s));
    }
}

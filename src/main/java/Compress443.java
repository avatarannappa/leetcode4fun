/**
 * 443. 压缩字符串
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/1
 * @see CompressString0106M
 */
public class Compress443 {

    public int compress(char[] chars) {
        if (chars == null || chars.length < 1) {
            return 0;
        }
        int length = chars.length;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char pre = chars[0];
        for (int i = 1; i < length; i++) {
            char a = chars[i];
            if (a != pre) {
                sb.append(pre);
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            } else {
                count++;
            }
            pre = a;
        }
        sb.append(pre);
        if (count > 1) {
            sb.append(count);
        }

        String result = sb.toString();
        if (result.length() <= length) {
            for (int i = 0; i < result.length(); i++) {
                chars[i] = result.charAt(i);
            }
        }
        return result.length() > length ? length : result.length();
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'a', 'b'};
        System.out.println(new Compress443().compress(chars));
    }

}

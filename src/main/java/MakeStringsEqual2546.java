/**
 * 2546. 执行逐位运算使字符串相等
 * medium
 *
 * @author avatarannappa
 * @date 2023/6/28
 */
public class MakeStringsEqual2546 {

    public boolean makeStringsEqual(String s, String target) {
        // 规律
        // 1 0 -> 1 1
        // 1 1 -> 1 0
        // 0 0 -> 0 0
        // 都有1，或都是0
        return s.contains("1") == target.contains("1");
    }

    public static void main(String[] args) {
        String s = "0100";
        String target = "1000";
        // true
        System.out.println(new MakeStringsEqual2546().makeStringsEqual(s, target));
    }
}

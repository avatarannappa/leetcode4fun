/**
 * 2109. 向字符串添加空格.
 * medium
 *
 * @author avatarannappa
 * @version 2025/3/30
 */
public class AddSpaces2109 {

    public String addSpaces(String s, int[] spaces) {
        // 双指针
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 0; i < s.length();) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(' ');
                j++;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AddSpaces2109 solution = new AddSpaces2109();
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = { 8, 13, 15 };
        System.out.println(solution.addSpaces(s, spaces)); // Output: "Leetcode Helps Me Learn"
    }
}

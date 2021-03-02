/**
 * 744. 寻找比目标字母大的最小字母
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/2
 */
public class NextGreatestLetter744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int[] abc = new int[26];
        for (char letter : letters) {
            abc[letter - 'a'] = 1;
        }
        int start = ((target - 'a') + 1) % 26;
        for (int i = start; i < start + 26; i++) {
            if (abc[i % 26] != 0) {
                return (char) ('a' + i % 26);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'z';
        System.out.println(new NextGreatestLetter744().nextGreatestLetter(letters, target));
    }
}

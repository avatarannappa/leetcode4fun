/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/21
 */
public class IsPrefixOfWord1455 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1;
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith(searchWord)) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String sentence = "i love eating burger";
        String searchWord = "burg";
        // 4
        System.out.println(new IsPrefixOfWord1455().isPrefixOfWord(sentence, searchWord));
    }
}

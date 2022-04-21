/**
 * 824. 山羊拉丁文.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/4/21
 */
public class ToGoatLatin824 {

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0))) {
                sb.append(word).append("ma");
            } else {
                sb.append(word.substring(1)).append(word.charAt(0)).append("ma");
            }
            for (int j = 0; j < i + 1; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I'
            || c == 'O' || c == 'U';
    }


    public static void main(String[] args) {
        ToGoatLatin824 solution = new ToGoatLatin824();
        String sentence = "I speak Goat Latin";
        // "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        System.out.println(solution.toGoatLatin(sentence));
    }
}
    

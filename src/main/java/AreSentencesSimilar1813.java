/**
 * 1813. 句子相似性 III
 * medium
 *
 * @author avatarannappa
 * @date 2023/1/16
 */
public class AreSentencesSimilar1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // 模拟
        // TODO 双指针
        if (sentence1.length() < sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        if (sentence1.length() == sentence2.length()) {
            return sentence1.equals(sentence2);
        }
        if ((sentence1.startsWith(sentence2) && sentence1.charAt(sentence2.length()) == ' ') 
            || (sentence1.endsWith(sentence2) && sentence1.charAt(sentence1.length() - sentence2.length() - 1) == ' ')) {
            return true;
        }
        String[] arr = sentence2.split(" ");
        String str = "";
        for (String s : arr) {
            str += s + " ";
            if (str.length() > sentence2.length()) {
                break;
            }
            String rStr = " " + sentence2.substring(str.length());
            if (sentence1.startsWith(str) && sentence1.endsWith(rStr)) {
                return true;
            }
            
        }
        return false;
    }

    public static void main(String[] args) {
        String sentence1 = "A A", sentence2 = "A aA";
        // false
        System.out.println(new AreSentencesSimilar1813().areSentencesSimilar(sentence1, sentence2));
    }
}

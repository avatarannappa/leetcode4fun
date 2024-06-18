/**
 * 2288. 价格减免
 * medium
 *
 * @author avatarannappa
 * @date 2024/6/18
 */
public class DiscountPrices2288 {

    public String discountPrices(String sentence, int discount) {
        // 模拟
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            stringBuilder.append(discountPrice(word, discount)).append(" ");
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public String discountPrice(String word, int discount) {
        if (!word.startsWith("$") || word.length() < 2) {
            return word;
        }
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) > '9' || word.charAt(i) < '0') {
                return word;
            }
        }
        double price = Double.parseDouble(word.substring(1));
        return String.format("$%.2f", (price - (price * discount / 100)));
    }

    public static void main(String[] args) {
        String sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
        int discount = 100;
        // 输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
        System.out.println(new DiscountPrices2288().discountPrices(sentence, discount));
    }
}

/**
 * 2038. 如果相邻两个颜色均相同则删除当前颜色.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/3/22
 */
public class Winnerofgame2038 {

    public boolean winnerOfGame(String colors) {
        int aCount = 0;
        int bCount = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            char cur = colors.charAt(i);
            char pre = colors.charAt(i - 1);
            char post = colors.charAt(i + 1);
            if (cur == pre && cur == post) {
                if (cur == 'A') {
                    aCount++;
                } else {
                    bCount++;
                }
            }
        }
        return aCount > bCount;
    }

    public static void main(String[] args) {
        String colors = "BBBAAAABB";
        // true
        System.out.println(new Winnerofgame2038().winnerOfGame(colors));
    }

}

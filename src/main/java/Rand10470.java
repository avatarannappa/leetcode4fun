import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/3
 */
public class Rand10470 {

    public int rand10() {
        // 独立事件 -> 打表 -> 进制
        int num = Integer.MAX_VALUE;
        while (num > 40) {
            num = (rand7() - 1) * 7 + rand7() - 1;
        }
        return num % 10 + 1;
    }

    public int rand7() {
        Random random = new Random(7);
        return random.nextInt();
    }

}

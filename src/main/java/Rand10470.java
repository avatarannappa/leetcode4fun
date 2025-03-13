import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/3
 */
public class Rand10470 {

    public int rand10Old() {
        // 独立事件，比较慢
        while (true) {
            int r = 7 * (rand7() - 1) + rand7() - 1;
            if (r >= 1 && r <= 10) {
                return r;
            }
        }
    }

    public int rand10() {
        // 加速。独立事件 -> 打表 -> 进制
        int num = Integer.MAX_VALUE;
        while (num > 40) {
            num = (rand7() - 1) * 7 + rand7() - 1;
        }
        return num % 10 + 1;
    }
    
    public int rand2() {
        // 加速
        while (true) {
            int r = rand7();
            if (r <= 6) {
                return r % 2 + 1;
            }
        }
    }

    public int rand7() {
        Random random = new Random(7);
        return random.nextInt();
    }

}

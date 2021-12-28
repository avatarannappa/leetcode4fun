import com.alibaba.fastjson.JSON;
import java.util.HashMap;

/**
 * 1518. 换酒问题.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/12/28
 */
public class NumWaterBottles1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int left = 0;

        while (numBottles != 0) {
            int temp = numBottles + left;
            numBottles = temp / numExchange;
            left = temp % numExchange;
            ans += numBottles;
        }

        return ans;
    }

    public static void main(String[] args) {
        int numBottles = 15;
        int numExchange = 4;
        // 19
        System.out.println(new NumWaterBottles1518().numWaterBottles(numBottles, numExchange));
        
        String s = "scheme?extra=" + JSON.toJSONString(new HashMap<>());
        System.out.println(s);
    }
}

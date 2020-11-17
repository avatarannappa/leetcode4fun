/**
 * 复利计算
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/16
 */
public class FuliUtil {

    public double CompoundInterest(double presentValue, double rate, int period) {
        if (period == 0) {
            return presentValue;
        }
        return CompoundInterest(presentValue * (1 + rate), rate, period - 1);
    }

    public static void main(String[] args) {
        // 本金
        double presentValue = 100;
        // 利率
        double rate = 0.20;
        // 周期
        int period = 3;
        System.out.println(new FuliUtil().CompoundInterest(presentValue, rate, period));
    }
}

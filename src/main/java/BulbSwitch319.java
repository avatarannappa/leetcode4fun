/**
 * 319. 灯泡开关.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/22
 */
public class BulbSwitch319 {

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(new BulbSwitch319().bulbSwitch(3));
    }
}

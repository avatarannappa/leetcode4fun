/**
 * 458. 可怜的小猪.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/1
 */
public class PoorPigs458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 信息论
        // # 特别经典的一道题，1024个桶里，有一个有毒，十个小白鼠可以做测试，怎么一次找到有毒的那个
        // # 将0~1023写成二进制，最多是十位，每个小白鼠喝所有某一位为1的（一鼠一位）
        // # 最终要找的那个就是所有死的小白鼠的位为1，其他位为0
        // # 我们知道十只小白鼠一次可以试出2^10个桶，如果是两次呢？
        // # 其实两次可以看成三进制，每个小白鼠可以在两轮内试出某一位是0还是1还是2
        // # 第一次死就是那一位为1，第二次是那一次为2，没死就是那一位为0
        // # 这样来看的话，
        // # x轮就该转换成(x+1)进制, 我们要找buckets在x+1进制下是几位，就是我们至少需要的小白鼠个数了
        int states = minutesToTest / minutesToDie + 1;
        int pigs = (int) Math.ceil(Math.log(buckets) / Math.log(states));
        return pigs;
    }

    public static void main(String[] args) {
        double a = 25;
        double b = 5;
        System.out.println(Math.log(a));
        System.out.println(Math.log(b));
        System.out.println(Math.log(a)/Math.log(b));
    }
}

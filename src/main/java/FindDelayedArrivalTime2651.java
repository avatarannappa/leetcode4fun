/**
 * 2651. 计算列车到站时间
 * easy
 *
 * @author avatarannappa
 * @date 2023/9/8
 */
public class FindDelayedArrivalTime2651 {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        // 简单模拟
        return (arrivalTime + delayedTime) % 24;
    }
}

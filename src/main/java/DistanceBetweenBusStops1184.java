/**
 * 1184. 公交站间的距离
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/7/24
 */
public class DistanceBetweenBusStops1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int a = 0, b = 0;
        if (start > destination) {
            int temp = destination;
            destination = start;
            start = temp;
        }
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                a += distance[i];
            } else {
                b += distance[i];
            }
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int[] distance = {1, 2, 3, 4};
        int start = 3;
        int destination = 1;
        //
        System.out.println(new DistanceBetweenBusStops1184().distanceBetweenBusStops(distance, start, destination));
    }
}

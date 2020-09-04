import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 841. 钥匙和房间.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/4
 */
public class CanVisitAllRooms841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] mask = new int[1000];
        Queue<Integer> roomQueue = new LinkedList<>();
        mask[0] = 1;
        roomQueue.addAll(rooms.get(0));
        while (!roomQueue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!roomQueue.isEmpty()) {
                int key = roomQueue.poll();
                mask[key] = 1;
                List<Integer> nextKeys = rooms.get(key);
                for (Integer nextKey : nextKeys) {
                    if (mask[nextKey] == 0) {
                        temp.add(nextKey);
                    }
                }
            }
            roomQueue.addAll(temp);
        }

        for (int j = 0; j < rooms.size(); j++) {
            if (mask[j] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        room0.add(1);
        List<Integer> room1 = new ArrayList<>();
        room1.add(2);
        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        List<Integer> room3 = new ArrayList<>();
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        System.out.println(new CanVisitAllRooms841().canVisitAllRooms(rooms));
    }

}

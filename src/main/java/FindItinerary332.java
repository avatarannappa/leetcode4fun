import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 332. 重新安排行程.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/1
 */
public class FindItinerary332 {

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            PriorityQueue<String> queue = map.getOrDefault(ticket.get(0), new PriorityQueue<>());
            queue.offer(ticket.get(1));
            map.put(ticket.get(0), queue);
        }
        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    public void dfs(String source) {
        while (map.containsKey(source) && map.get(source).size() > 0) {
            String target = map.get(source).poll();
            dfs(target);
        }
        result.add(source);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        String[][] ticketsArray = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        for (String[] strings : ticketsArray) {
            List<String> temp = new ArrayList<>(Arrays.asList(strings));
            tickets.add(temp);
        }
        System.out.println(new FindItinerary332().findItinerary(tickets));
    }
}

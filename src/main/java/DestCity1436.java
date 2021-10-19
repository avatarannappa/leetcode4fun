import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1436. 旅行终点站,Destination City. easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/10/19
 */
public class DestCity1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> startSet = new HashSet<>();
        paths.forEach(path -> startSet.add(path.get(0)));
        String res = null;
        for (List<String> path : paths) {
            if (!startSet.contains(path.get(1))) {
                res = path.get(1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("b");
        l1.add("c");
        List<String> l2 = new ArrayList<>();
        l2.add("d");
        l2.add("b");
        List<String> l3 = new ArrayList<>();
        l3.add("c");
        l3.add("a");
        paths.add(l1);
        paths.add(l2);
        paths.add(l3);
        System.out.println(new DestCity1436().destCity(paths));
    }
}

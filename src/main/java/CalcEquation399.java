import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 399. 除法求值
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/20
 */
public class CalcEquation399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<Set<String>> setList = new ArrayList<>();
        // 图的出度map
        List<Map<String, Map<String, Double>>> mapList = new ArrayList<>();
        Set<String> exit = new HashSet<>();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < values.length; i++) {
                List<String> equation = equations.get(i);
                double value = values[i];
                String op0 = equation.get(0);
                String op1 = equation.get(1);

                boolean has = false;
                int index = 0;
                for (Map<String, Map<String, Double>> map : mapList) {
                    Set<String> set = setList.get(index);
                    if (set.contains(op0) && set.contains(op1)) {
                        break;
                    } else if (set.contains(op0) || set.contains(op1)) {
                        Map<String, Double> m;
                        if (map.containsKey(op0)) {
                            m = map.get(op0);
                            m.put(op1, value);
                            map.put(op0, m);

                            double reverse = 1 / value;
                            Map<String, Double> mr = new HashMap<>();
                            mr.put(op0, reverse);
                            map.put(op1, mr);
                        } else {
                            m = map.get(op1);
                            Map<String, Double> n = new HashMap<>();
                            n.put(op1, value);
                            map.put(op0, n);

                            double reverse = 1 / value;
                            m.put(op0, reverse);
                            map.put(op1, m);
                        }

                        set.add(op0);
                        set.add(op1);

                        has = true;
                        break;
                    }
                    index++;
                }
                if (!has) {
                    Map<String, Map<String, Double>> map = new HashMap<>();
                    Map<String, Double> m = new HashMap<>();
                    m.put(op1, value);
                    map.put(op0, m);

                    double reverse = 1 / value;
                    Map<String, Double> mr = new HashMap<>();
                    mr.put(op0, reverse);
                    map.put(op1, mr);

                    mapList.add(map);

                    Set<String> s = new HashSet<>();
                    s.add(op0);
                    s.add(op1);
                    setList.add(s);

                }
            }
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String op0 = query.get(0);
            String op1 = query.get(1);
            int index = 0;
            boolean has = false;
            for (Map<String, Map<String, Double>> map : mapList) {
                Set<String> set = setList.get(index);

                if (set.contains(op0) && set.contains(op1)) {

                    Map<String, Map<String, Double>> tempMap = new HashMap<>();
                    for (String s : map.keySet()) {
                        Map<String, Double> t = new HashMap<>();
                        t.putAll(map.get(s));
                        tempMap.put(s, t);
                    }
                    has = true;

                    // bfs
                    Queue<Map<String, Double>> queue = new LinkedList<>();
                    queue.add(tempMap.get(op0));
                    double value = 1;
                    Set<String> exist = new HashSet<>();
                    exist.add(op0);
                    while (!queue.isEmpty()) {
                        Map<String, Double> node = queue.poll();
                        for (String s : node.keySet()) {
                            double v = node.get(s);
                            if (!exist.contains(s)) {
                                if (s.equals(op1)) {
                                    value = v;
                                    break;
                                }
                                Map<String, Double> nextNode = tempMap.get(s);
                                for (String s1 : nextNode.keySet()) {
                                    nextNode.put(s1, nextNode.get(s1) * v);
                                }
                                queue.add(nextNode);
                                exist.add(s);
                            }
                        }
                    }
                    result[i] = value;
                }
                index++;
            }
            if (!has) {
                result[i] = -1.0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new LinkedList<>();
        List<String> e1 = new LinkedList<>();
        e1.add("a");
        e1.add("b");
        List<String> e2 = new LinkedList<>();
        e2.add("e");
        e2.add("f");
        List<String> e3 = new LinkedList<>();
        e3.add("b");
        e3.add("e");
        equations.add(e1);
        equations.add(e2);
        equations.add(e3);

        double[] values = {3.4, 1.4, 2.3};

        List<List<String>> queries = new LinkedList<>();
        List<String> q1 = new LinkedList<>();
        q1.add("a");
        q1.add("c");
        List<String> q2 = new LinkedList<>();
        q2.add("b");
        q2.add("a");
        List<String> q3 = new LinkedList<>();
        q3.add("a");
        q3.add("e");
        List<String> q4 = new LinkedList<>();
        q4.add("a");
        q4.add("f");
        //        queries.add(q1);
        //        queries.add(q2);
        //        queries.add(q3);
        queries.add(q4);
        System.out.println(Arrays.toString(new CalcEquation399().calcEquation(equations, values, queries)));

    }

}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 399. 除法求值
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/19
 */
public class CalcEquation399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<Set<String>> setList = new ArrayList<>();
        List<Map<String, Map<String, Double>>> mapList = new ArrayList<>();
        Set<String> exit = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String op0 = equation.get(0);
            String op1 = equation.get(1);

            boolean has = false;
            for (Map<String, Map<String, Double>> map : mapList) {
                if (map.containsKey(op0) && map.containsKey(op1)) {
                    break;
                } else if (map.containsKey(op0)) {
                    double reverse = 1 / value;
                    Map<String, Double> m0 = new HashMap<>();
                    m0.put(op0, value);
                    map.put(op1, m0);
                    has = true;
                    break;
                } else if (map.containsKey(op1)) {
                    Map<String, Double> m1 = new HashMap<>();
                    m1.put(op1, value);
                    map.put(op0, m1);
                    has = true;
                    break;
                }
            }
            if (!has) {
                Map<String, Map<String, Double>> map = new HashMap<>();
                Map<String, Double> m1 = new HashMap<>();
                m1.put(op1, value);
                map.put(op0, m1);
                mapList.add(map);
            }
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(0);
            String op0 = query.get(0);
            String op1 = query.get(1);
            for (Map<String, Map<String, Double>> map : mapList) {
                if (map.containsKey())
            }
        }

        return result;
    }

}

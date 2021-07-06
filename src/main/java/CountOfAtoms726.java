import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 726. 原子的数量
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/7/6
 */
public class CountOfAtoms726 {

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = recursion(formula);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 1) {
                sb.append(key);
                sb.append(value);
            } else {
                sb.append(key);
            }
        }
        return sb.toString();
    }

    public TreeMap<String, Integer> recursion(String formula) {
        TreeMap<String, Integer> start = new TreeMap<>();
        int first = formula.indexOf("(");
        if (first >= 0) {
            start = recursion(formula.substring(0, first));
            int last = pair(first, formula);
            int tempLast = last;
            int count = 0;
            last++;
            while (last < formula.length() && formula.charAt(last) >= '0' && formula.charAt(last) <= '9') {
                count = count * 10 + formula.charAt(last) - '0';
                last++;
            }
            count = Math.max(1, count);
            TreeMap<String, Integer> end = recursion(formula.substring(last));
            TreeMap<String, Integer> mid = recursion(formula.substring(first + 1, tempLast));
            if (count > 1) {
                for (Map.Entry<String, Integer> entry : mid.entrySet()) {
                    mid.put(entry.getKey(), entry.getValue() * count);
                }
            }
            merge(start, end);
            merge(start, mid);
        } else {
            start = simple(formula);
        }
        return start;
    }

    public TreeMap<String, Integer> simple(String formula) {
        TreeMap<String, Integer> res = new TreeMap<>();
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (i == formula.length() - 1) {
                res.put(String.valueOf(c), res.getOrDefault(String.valueOf(c), 0) + 1);
            } else {
                String k = String.valueOf(c);
                Integer count = 1;
                char next = formula.charAt(i + 1);
                if (next >= 'A' && next <= 'Z') {
                } else if (next >= 'a' && next <= 'z') {
                    i++;
                    while (i < formula.length() && formula.charAt(i) >= 'a' && formula.charAt(i) <= 'z') {
                        k += formula.charAt(i);
                        i++;
                    }
                    if (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                        int temp = 0;
                        while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                            temp = temp * 10 + formula.charAt(i) - '0';
                            i++;
                        }
                        count = temp;
                    }
                    i--;
                } else {
                    i++;
                    int temp = 0;
                    while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                        temp = temp * 10 + formula.charAt(i) - '0';
                        i++;
                    }
                    count = temp;
                    i--;
                }
                res.put(k, res.getOrDefault(k, 0) + count);
            }
        }
        return res;
    }

    public void merge(TreeMap<String, Integer> a, TreeMap<String, Integer> b) {
        for (Map.Entry<String, Integer> e : b.entrySet()) {
            String key = e.getKey();
            Integer value = e.getValue();
            if (a.containsKey(key)) {
                a.put(key, a.get(key) + value);
            } else {
                a.put(key, value);
            }
        }
    }

    public int pair(int start, String s) {
        Stack<Character> stack = new Stack<>();
        stack.add('(');
        int i = start+1;
        while (!stack.isEmpty()) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                stack.pop();
            }
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        String formula = "Mg(OH)2";
        // "Be2 K4 N2 O14 S4"
        System.out.println(new CountOfAtoms726().countOfAtoms(formula));
    }

}

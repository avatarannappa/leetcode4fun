import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author avatarannappa
 * @version 1.0, 2019/2/21
 */
public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {

        // result
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        // number - char map
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        // 初始化数组
        Integer arrayLen = 1;
        int digitLen = digits.length();
        for (int i = 0; i < digitLen; i++) {
            if (digits.charAt(i) == '9' || digits.charAt(i) == '7') {
                arrayLen *= 4;
            } else {
                arrayLen *= 3;
            }

        }
        String[] array = new String[arrayLen];
        // 重复次数
        int[] repeatArray = new int[digitLen];
        repeatArray[digitLen - 1] = arrayLen / map.get(digits.charAt(digitLen - 1)).size();
        // 步长
        int[] stepArray = new int[digitLen];
        stepArray[digitLen - 1] = 1;
        // 初始化重 复次数 和 步长
        for (int i = digitLen - 1; i > 0; i--) {
            int charSizePre = map.get(digits.charAt(i)).size();
            int charSizeNow = map.get(digits.charAt(i - 1)).size();
            repeatArray[i - 1] = repeatArray[i] / charSizeNow;
            stepArray[i - 1] = stepArray[i] * charSizePre;
        }
        // 初始化
        for (int d = digitLen - 1; d >= 0; d--) {

            char nowNum = digits.charAt(d);
            List<Character> charList = map.get(nowNum);
            int charSize = charList.size();

            int repeats = repeatArray[d];
            int steps = stepArray[d];

            for (int charIndex = 0; charIndex < charSize; charIndex++) {

                for (int repeat = 0; repeat < repeats; repeat++) {
                    for (int step = 0; step < steps; step++) {
                        if (array[charIndex * steps + step + repeat * (arrayLen / repeats)] == null) {
                            array[charIndex * steps + step + repeat * (arrayLen / repeats)] =
                                    "" + charList.get(charIndex);
                        } else {
                            array[charIndex * steps + step + repeat * (arrayLen / repeats)] =
                                    charList.get(charIndex) + array[charIndex * steps + step + repeat * (arrayLen
                                                                                                                 /
                                                                                                                 repeats)];
                        }
                    }
                }
            }

        }
        result = new ArrayList<>(Arrays.asList(array));
        return result;
    }

    public static List<String> letterCombinationsRecursion(Integer index, String digits,
                                                           Map<Character, List<Character>> map, List<String> list,
                                                           String tempStr) {
        if (index < digits.length() - 1) {
            for (int i = 0; i < map.get(digits.charAt(index)).size(); i++) {
                letterCombinationsRecursion(index + 1, digits, map, list,
                        tempStr + map.get(digits.charAt(index)).get(i));
            }
            index++;
        } else {
            for (int i = 0; i < map.get(digits.charAt(index)).size(); i++) {
                list.add(tempStr + map.get(digits.charAt(index)).get(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String digits = "239";
        List<String> result = letterCombinations(digits);
        for (String num : result) {
            System.out.print(num + ",");
        }

        System.out.println("--------------------------");
        // number - char map
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        List<String> result2 = new ArrayList<>();
        letterCombinationsRecursion(0, digits, map, result2, "");
        for (String num : result2) {
            System.out.print(num + ",");
        }
    }
}

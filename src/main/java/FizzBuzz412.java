import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 412. Fizz Buzz
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/29
 */
public class FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FizzBuzz412().fizzBuzz(16).toArray()));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Strings;

/**
 * @author avatarannappa
 * @version 1.0, 2019/1/14
 */
public class Tax {

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        stringCollection.stream().filter(Strings::isNullOrEmpty).forEach(System.out::println);

    }
}

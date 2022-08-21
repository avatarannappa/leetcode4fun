import java.util.LinkedList;
import java.util.List;

/**
 * 1656. 设计有序流
 * easy
 *
 * @author avatarannappa
 * @date 2022/8/16
 */
public class OrderedStream1656 {

    int ptr = 1;
    String[] arr;

    public OrderedStream1656(int n) {
        arr = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        List<String> output = new LinkedList<>();
        arr[idKey] = value;
        if (ptr == idKey) {
            while (ptr < arr.length && arr[ptr] != null) {
                output.add(arr[ptr]);
                ptr++;
            }
        }
        return output;
    }

}

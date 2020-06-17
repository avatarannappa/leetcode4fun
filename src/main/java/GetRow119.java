import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/17
 */
public class GetRow119 {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        int pre = 0;
        for (int i = 0; i < rowIndex+1; i++) {
            List<Integer> row = new ArrayList<Integer>(i + 1);
            for (int x = 0; x < (i + 1); x++) {
                row.add(1);
            }
            if (pre > 0) {
                for (int j = 1; j < row.size() - 1; j++) {
                    List<Integer> preRow = list.get(pre);
                    row.set(j, preRow.get(j - 1) + preRow.get(j));
                }
            }
            list.add(row);
            pre = i;
        }

        return list.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(new GetRow119().getRow(3));
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/4
 */
public class Generate118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        int pre = 0;
        for (int i = 0; i < numRows; i++) {
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

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Generate118().generate(5));
    }
}

/**
 * 799.香槟塔
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/11/20
 */
public class ChampagneTower799 {

    public double champagneTower(int poured, int queryRow, int queryGlass) {
        // 模拟
        double[] row = {poured};
        for (int i = 1; i <= queryRow; i++) {
            double[] nextRow = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double now = row[j];
                if (now > 1) {
                    nextRow[j] += (now - 1) / 2;
                    nextRow[j + 1] += (now - 1) / 2;
                }
            }
            row = nextRow;
        }
        return Math.min(1, row[queryGlass]);
    }

    public static void main(String[] args) {
        int poured = 100000009;
        int queryRow = 33;
        int queryGlass = 17;
        // 1
        System.out.println(new ChampagneTower799().champagneTower(poured, queryRow, queryGlass));
    }
}

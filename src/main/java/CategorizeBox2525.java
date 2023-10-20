/**
 * 2525. 根据规则将箱子分类
 * easy
 *
 * @author avatarannappa
 * @date 2023/10/20
 */
public class CategorizeBox2525 {

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = false;
        boolean heavy = false;
        if (length >= 10000 || width >= 10000 || height >= 10000 || 1L * length * width * height >= 1000000000L) {
            bulky = true;
        }

        if (mass >= 100) {
            heavy = true;
        }

        if (bulky && heavy) {
            return "Both";
        } else if (bulky) {
            return "Bulky";
        } else if (heavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
    }
}

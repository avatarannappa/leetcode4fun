/**
 * 69. x的平方根.
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/4
 */
public class MySqrt69 {

    double xOrigin;

    public int mySqrt(int x) {
        xOrigin = x;
        if (x == 0) {
            return 0;
        }
        return (int) sqrt(x);
    }

    public double sqrt(double x) {
        double xNew = (x + xOrigin / x) / 2;
        if (xNew == x) {
            return x;
        } else {
            return sqrt(xNew);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt69().mySqrt(8));
    }
}

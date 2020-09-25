/**
 * 223. 矩形面积.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/25
 */
public class ComputeArea223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // 投影
        return (C - A) * (D - B) + (G - E) * (H - F) - getLength(A, C, E, G) * getLength(B, D, F, H);
    }

    public int getLength(long a, long c, long e, long g) {
        if (e <= a) {
            return (int) Math.max(Math.min(c, g) - Math.max(a, e), 0);
        } else {
            return getLength(e, g, a, c);
        }
    }

}

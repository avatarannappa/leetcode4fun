import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 735. 行星碰撞
 * medium
 *
 * @author avatarannappa
 * @date 2022/11/1
 */
public class AsteroidCollision735 {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                deque.addLast(asteroid);
            } else {
                while (!deque.isEmpty() && deque.peekLast() > 0 && deque.peekLast() < -asteroid) {
                    int last = deque.pollLast();
                }

                if (deque.isEmpty() || deque.peekLast() < 0) {
                    deque.addLast(asteroid);
                } else if (deque.peekLast() == -asteroid) {
                    deque.pollLast();
                }
            }
        }
        int[] ans = new int[deque.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = deque.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        // 5, 10
        System.out.println(Arrays.toString(new AsteroidCollision735().asteroidCollision(asteroids)));
    }
}

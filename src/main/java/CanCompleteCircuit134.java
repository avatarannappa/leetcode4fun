/**
 * 134. 加油站,
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/8
 */
public class CanCompleteCircuit134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int leftGas = 0;
            for (int j = 0; j < gas.length; j++) {
                int index = (i + j) % gas.length;
                leftGas = leftGas + gas[index] - cost[index];
                if (leftGas < 0) {
                    break;
                }
            }
            if (leftGas >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new CanCompleteCircuit134().canCompleteCircuit(gas, cost));
    }
}

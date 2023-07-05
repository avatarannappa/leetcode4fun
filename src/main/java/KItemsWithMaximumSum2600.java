/**
 * 2600. K 件物品的最大和
 * easy
 *
 * @author avatarannappa
 * @date 2023/7/5
 */
public class KItemsWithMaximumSum2600 {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) {
            return k;
        } else if (numOnes + numZeros >= k) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }
    
}

/**
 * 838. 推多米诺.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/26
 */
public class PushDominoes838 {
    public String pushDominioes(String dominoes) {
        char pre = '.';
        int preIndex = 0;
        char[] arr = new char[dominoes.length()];
        for (int i = 0; i < dominoes.length(); i++) {
            char d = dominoes.charAt(i);
            if (d == '.') {
                if (pre == 'R') {
                    arr[i] = pre;
                } else {
                    arr[i] = d;
                }
            } else if (d == 'L') {
                if (pre == 'R') {
                    int mid = preIndex + (i - preIndex) / 2;
                    if ((i - preIndex) % 2 == 0) {
                        arr[mid] = '.';
                    }
                    for (int j = mid + 1; j <= i; j++) {
                        arr[j] = 'L';
                    }
                } else {
                    for (int j = preIndex; j <= i; j++) {
                        arr[j] = 'L';
                    }
                }
                pre = 'L';
                preIndex = i;
            } else {
                arr[i] = 'R';
                pre = 'R';
                preIndex = i;
            }

        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        // "LL.RR.LLRRLL.."
        System.out.println(new PushDominoes838().pushDominioes(dominoes));
    }
}

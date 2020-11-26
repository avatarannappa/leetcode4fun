/**
 * 306. 累加数
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/26
 */
public class IsAdditiveNumber306 {

    private String num;

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        this.num = num;
        for (int i = 0; i < num.length(); i++) {
            // 前两个数
            long num1 = getNumber(0, i);
            if (num1 < 0) {
                continue;
            }
            for (int j = i + 1; j < num.length(); j++) {
                long num2 = getNumber(i + 1, j);
                if (num2 < 0) {
                    continue;
                }
                if (j < num.length() - 1 && backTracking(num1, num2, j + 1)) {
                    // 回溯+剪枝
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking(long num1, long num2, int index) {
        if (index == num.length()) {
            return true;
        }
        for (int i = index; i < num.length(); i++) {
            long sum = getNumber(index, i);
            if (sum < 0) {
                continue;
            }
            if (sum < num1 + num2) {
                continue;
            }
            if (sum > num1 + num2) {
                // 剪
                break;
            }
            if (backTracking(num2, sum, i + 1)) {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------
    public boolean isAdditiveNumberMy(String num) {
        // 回溯+剪枝
        if (num == null || num.length() < 3) {
            return false;
        }
        this.num = num;
        return backTrackingMy(0, 0, 0, 0);
    }

    public boolean backTrackingMy(int index, int level, long num1, long num2) {
        long sum = num1 + num2;
        for (int i = index; i < num.length(); i++) {
            long now = getNumber(index, i);
            if (now < 0) {
                continue;
            }
            if (level >= 2) {
                if (now < sum) {
                    continue;
                } else if (now > sum) {
                    break;
                } else {
                    if (i == num.length() - 1) {
                        return true;
                    } else {
                        return backTrackingMy(i + 1, level + 1, num2, now);
                    }
                }
            } else if (level == 0) {
                if (backTrackingMy(i + 1, level + 1, now, num2)) {
                    return true;
                }
            } else if (level == 1) {
                if (backTrackingMy(i + 1, level + 1, num1, now)) {
                    return true;
                }
            }
        }
        return false;
    }

    public long getNumber(int l, int r) {
        try {
            if (r > l && num.charAt(l) == '0') {
                return -1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = l; i <= r; i++) {
                sb.append(num.charAt(i));
            }
            return Long.parseLong(sb.toString());
        } catch (NumberFormatException e) {
            // 例子：11235813213455890144
            return -1;
        }
    }

    public static void main(String[] args) {
        String num = "123";
        System.out.println(new IsAdditiveNumber306().isAdditiveNumber(num));
    }
}

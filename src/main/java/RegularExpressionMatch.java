/**
 * @author avatarannappa
 * @version 1.0, 2019/2/14
 */
public class RegularExpressionMatch {

    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() > 0 && p.length() == 0) {
            return false;
        }
        if (s.length() == 0 && p.length() > 0) {
            if (p.length() % 2 == 1) {
                return false;
            }
            for (int i = 0; i < p.length(); i++) {
                if (i % 2 == 1 && p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        char sch = s.charAt(s.length() - 1);
        char pch = p.charAt(p.length() - 1);
        if (pch == '.') {
            return isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
        } else if (pch == '*') {
            boolean result = false;
            char pre = p.charAt(p.length() - 2);
            if (pre == '.') {
                for (int i = s.length(); i >= 0; i--) {
                    result = result || isMatch(s.substring(0, i), p.substring(0, p.length() - 2));
                }
            } else {
                int lastIndex = -1;
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (pre != s.charAt(i)) {
                        lastIndex = i;
                        break;
                    }
                }
                for (int i = lastIndex; i < s.length(); i++) {
                    result = result || isMatch(s.substring(0, i + 1), p.substring(0, p.length() - 2));
                }
            }
            return result;
        } else if (pch == sch) {
            return isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
        } else {
            return false;
        }
    }

    public static boolean isMatchMy(String s, String p) {

        int sLen = s.length();
        int pLen = p.length();

        if (sLen == 0 && pLen == 0) {
            // 递归结束条件，string和pattern同时无数据
            return true;
        } else if (sLen > 0 && pLen == 0) {
            // 递归结束条件，string还有数据，pattern无数据
            return false;
        } else if (sLen == 0 && pLen > 0) {
            // 递归结束条件，string无数据，pattern还有数据
            if (pLen % 2 == 1) {
                // 奇数，不管是多出a-z . *都没有完全匹配，如：ab*
                return false;
            }
            // 如果偶数不是*，则没有完全匹配，如：aab*
            for (int i = 1; i <= pLen / 2; i++) {
                if (p.charAt(i * 2 - 1) != '*') {
                    return false;
                }
            }
            return true;
        } else {
            // string和pattern都有数据
            char sTail = s.charAt(sLen - 1);
            char pTail = p.charAt(pLen - 1);
            if (pTail == '.') {
                // 特殊字符. 递归比较
                return isMatch(s.substring(0, sLen - 1), p.substring(0, pLen - 1));
            } else if (pTail == '*') {
                // 特殊字符* 则需要比较*代表的重复字符
                char prePTail = p.charAt(pLen - 2);
                boolean result = false;

                if (prePTail == '.') {
                    // .*模式，循环递归s的每一种情况
                    for (int i = 0; i <= sLen; i++) {
                        result = result | isMatch(s.substring(0, sLen - i), p.substring(0, pLen - 2));
                    }
                } else {
                    // a-z*模式
                    int repeatLen = 0;
                    for (int i = sLen - 1; i >= 0; i--) {
                        if (s.charAt(i) == prePTail) {
                            repeatLen++;
                        } else {
                            break;
                        }
                    }
                    if (repeatLen == 0) {
                        // 递归，重复0次情况
                        result = isMatch(s, p.substring(0, pLen - 2));
                    } else {
                        // 递归比较每一种重复字符sub的情况
                        for (int i = 0; i <= repeatLen; i++) {
                            result = result | isMatch(s.substring(0, sLen - i), p.substring(0, pLen - 2));
                        }
                    }
                }
                return result;

            } else {
                // 正常字符串，直接比较字符是否一致
                if (pTail == sTail) {
                    // 一致，递归比较
                    return isMatch(s.substring(0, sLen - 1), p.substring(0, pLen - 1));
                } else {
                    // 递归结束条件，字符不一致
                    return false;
                }

            }
        }
    }

    public static boolean isMatchPre(String s, String p) {
        if (p.isEmpty()) {
            // 递归结束条件，完全匹配
            return s.isEmpty();
        }
        if (s.isEmpty()) {
            if (p.isEmpty()) {
                return true;
            } else if (p.length() % 2 == 0) {
                for (int i = 0; i < p.length() / 2; i++) {
                    if (p.charAt(i * 2 + 1) != '*') {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }

        if (p.length() > 1) {
            if (p.charAt(1) == '*') {
                if (p.charAt(0) == s.charAt(0)) {
                    for (int i = 0; i <= s.length(); i++) {
                        if (i < s.length() && s.charAt(i) != p.charAt(0)) {
                            return isMatchPre(s.substring(i, s.length()), p.substring(2, p.length()));
                        } else if (isMatchPre(s.substring(i, s.length()), p.substring(2, p.length()))) {
                            return true;
                        }
                    }
                    return false;
                } else if (p.charAt(0) == '.') {
                    for (int i = 0; i <= s.length(); i++) {
                        if (isMatchPre(s.substring(i, s.length()), p.substring(2, p.length()))) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return isMatchPre(s, p.substring(2, p.length()));
                }
            } else {
                return (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatchPre(s.substring(1, s.length()),
                        p.substring(1, p.length()));
            }
        } else {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }
    }

    public static boolean isMatchLoop(String s, String p) {
        return s.matches(p);
    }

    public static boolean isMatchOther(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatchOther(s, p.substring(2)) || (!s.isEmpty() && (s.charAt(0) == p.charAt(0)
                                                                                || p.charAt(0) == '.') && isMatchOther(
                    s.substring(1), p));
        } else {
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatchOther(s.substring(1),
                    p.substring(1));
        }
    }

    public static boolean isMatchNew(String s, String p) {
        // 递归容易栈溢出，-Xss设置栈大小。用动态规划比较好
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[sLen+1][pLen+1];
        memory[0][0] = true;
        for(int i = 0; i <= sLen; i++) {
            for(int j = 1; j <= pLen; j++) {
                if(p.charAt(j-1) == '*') {
                    memory[i][j] = memory[i][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && memory[i-1][j]);
                }else {
                    memory[i][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') && memory[i-1][j-1];
                }
            }
        }
        for (int i = 0; i <= sLen; i++) {
            for (int j = 0; j <= pLen; j++) {
                System.out.print(memory[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==========================");
        return memory[sLen][pLen];
    }

    public static void main(String[] args) {
        /*
         * mississippi
         * mis*is*p*.
         * aab
         * c*a*b
         * a
         * a*a
         * aa
         * a*
         */
        String s = "aa";
        String p = "a.";
        System.out.println("result : " + isMatchNew(s, p));
    }
}

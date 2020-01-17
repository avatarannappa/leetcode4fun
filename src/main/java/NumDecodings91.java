/**
 * 91. 解码方法
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/17
 */
public class NumDecodings91 {

    public int numDecodings(String s) {
        // 超时"7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665"
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int count = 0;
        char[] a = s.toCharArray();
        int[] r = new int[s.length() + 1];
        r[s.length()] = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (i == a.length - 1) {
                if (a[i] == '0') {
                    r[i] = 0;
                } else {
                    r[i] = 1;
                }
            } else {
                if (a[i] == '0') {
                    if (a[i + 1] == '0') {
                        return 0;
                    } else {
                        continue;
                    }
                } else {
                    if (a[i + 1] == '0' && (Integer.valueOf("" + a[i]) > 2)) {
                        return 0;
                    } else {
                        r[i] = r[i + 1];
                        int temp = Integer.valueOf("" + a[i] + a[i + 1]);
                        if (temp <= 26) {
                            r[i] = r[i] + r[i + 2];
                        }
                    }
                }
            }

        }
        return r[0];
    }

    public int numDecodings2(String s) {
        // 超时"7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665"
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        int count = 0;
        if (s.length() == 1) {
            count++;
        } else {
            count = numDecodings2(s.substring(1));
            if (s.charAt(0) <= '2') {
                int temp = Integer.valueOf(s.substring(0, 2));
                if (temp <= 26) {
                    if (s.length() == 2) {
                        count++;
                    } else {
                        count += numDecodings2(s.substring(2));
                    }
                }
            }
        }
        return count;
    }

    public int numDecodings1(String s) {
        // 超时"1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        char[] array = s.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        if (s.length() == 1) {
            count++;
        } else {
            sb.append(array[0]).append(array[1]);
            count = numDecodings1(s.substring(1));
            int temp = Integer.valueOf(sb.toString());
            if (temp <= 26) {
                if (s.length() == 2) {
                    count++;
                } else {
                    count += numDecodings1(s.substring(2));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String num = "101";
        // 10 1
        // 100 0
        // 101 1
        System.out.println(new NumDecodings91().numDecodings(num));
    }

}

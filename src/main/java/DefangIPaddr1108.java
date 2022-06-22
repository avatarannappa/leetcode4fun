/**
 * 1108. IP 地址无效化
 * easy
 *
 * @author chenhao138
 * @date 2022/6/22
 */
public class DefangIPaddr1108 {

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String address = "255.100.50.0";
        // 255[.]100[.]50[.]0
        System.out.println(new DefangIPaddr1108().defangIPaddr(address));
    }
}

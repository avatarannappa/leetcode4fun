/**
 * @author avatarannappa
 * @version 1.0, 2019/2/26
 */
public class EqualsTest {

    private Integer num;

    private String str;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        EqualsTest object = new EqualsTest();
        object.setStr("sss");
        if (object.getNum() == null || object.getNum().equals(1)) {
            System.out.println("equals");
        } else {
            System.out.println("not equal");
        }
    }
}

/**
 * @author avatarannappa
 * @version 1.0, 2019/4/3
 */
public class EmpTest {
    private Integer id;
    private Integer empLevel;
    private String mapingOrderLevel;
    private String empNo;
    private Integer orderNumLimit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpLevel() {
        return empLevel;
    }

    public void setEmpLevel(Integer empLevel) {
        this.empLevel = empLevel;
    }

    public String getMapingOrderLevel() {
        return mapingOrderLevel;
    }

    public void setMapingOrderLevel(String mapingOrderLevel) {
        this.mapingOrderLevel = mapingOrderLevel;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Integer getOrderNumLimit() {
        return orderNumLimit;
    }

    public void setOrderNumLimit(Integer orderNumLimit) {
        this.orderNumLimit = orderNumLimit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmpTest{");
        sb.append("id=").append(id);
        sb.append(", empLevel=").append(empLevel);
        sb.append(", mapingOrderLevel=").append(mapingOrderLevel);
        sb.append(", empNo='").append(empNo).append('\'');
        sb.append(", orderNumLimit=").append(orderNumLimit);
        sb.append('}');
        return sb.toString();
    }

    // 外部类私有的构造方法
    private EmpTest(Builder builder) {
        setId(builder.id);
        setEmpLevel(builder.empLevel);
        setMapingOrderLevel(builder.mapingOrderLevel);
        setEmpNo(builder.empNo);
        setOrderNumLimit(builder.orderNumLimit);
    }

    // 对外提供初始化EmpTest类的唯一接口，通过这个方法，获得内部类的实例
    public static Builder newBuilder() {
        return new Builder();
    }

    // 静态内部类：Builder
    private static final class Builder {
        private Integer id;
        private Integer empLevel;
        private String mapingOrderLevel;
        private String empNo;
        private Integer orderNumLimit;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder empLevel(Integer val) {
            empLevel = val;
            return this;
        }

        public Builder mapingOrderLevel(String val) {
            mapingOrderLevel = val;
            return this;
        }

        public Builder empNo(String val) {
            empNo = val;
            return this;
        }

        public Builder orderNumLimit(Integer val) {
            orderNumLimit = val;
            return this;
        }

        //通过内部类的build方法，实例化外部类，并给其实例各个字段赋值
        public EmpTest build() {
            return new EmpTest(this);
        }

    }

    public static void main(String[] args) {
        EmpTest test = EmpTest.newBuilder().empNo("1").empLevel(1).build();
        System.out.println(test);
    }

}

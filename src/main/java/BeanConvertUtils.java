import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;

/**
 * BeanConvertUtils
 */
public class BeanConvertUtils {

    static {
        // 注册sql.date的转换器，即允许BeanUtils.copyProperties时的源目标的sql类型的值允许为空
        ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
        ConvertUtils.register(new SqlDateConverter(null), java.util.Date.class);
        ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
    }

    /**
     * 对象属性copy，时间由Date格式化成String类型（yyyy-MM-dd HH:mm:ss）
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void bo2Vo(Object source, Object target) {
        ConvertUtils.register(new Converter() {
            public Object convert(Class type, Object value) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    return simpleDateFormat.parse(value.toString());
                } catch (ParseException e) {
                    throw new RuntimeException("converUtils bo2Vo parse time error, " + value.toString());
                }
            }
        }, java.util.Date.class);
        try {
            BeanUtils.copyProperties(target, source);
        } catch (Exception e) {
            throw new RuntimeException("converUtils bo2Vo copyProperties exception");
        }
    }

    /**
     * 对象属性copy，时间由String类型（yyyy-MM-dd HH:mm:ss）格式化成Date
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void vo2Bo(Object source, Object target) {
        ConvertUtils.register(new Converter() {
            public Object convert(Class type, Object value) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    return sdf.parse(value.toString());
                } catch (ParseException e) {
                    throw new RuntimeException("converUtils bo2Vo parse time error, " + value.toString());
                }
            }
        }, java.util.Date.class);
        try {
            BeanUtils.copyProperties(target, source);
        } catch (Exception e) {
            throw new RuntimeException("converUtils bo2Vo copyProperties exception");
        }
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("he");
        p.setAge(1);
        p.setBirthday(new Date());
        p.setGender("male");

        PersonVo v = new PersonVo();
        v.setName("vv");
        v.setAge(2);
        v.setBirthday("2019-03-14 22:37:56");
        v.setGender("female");

        BeanConvertUtils.bo2Vo(p, v);
        System.out.println(p);
        System.out.println(v);
    }

}


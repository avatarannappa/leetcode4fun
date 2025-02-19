package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 数组与列表转换工具类
 * 提供各种数组类型与List之间的转换方法
 *
 * @author avatarannappa
 * @version 2025/2/19
 */
public class Array2ListUtil {

    // Integer[]转int[]
    public static int[] convertToPrimitive(Integer[] integerArray) {
        return Optional.ofNullable(integerArray)
                .map(arr -> Arrays.stream(arr)
                        .mapToInt(Integer::intValue)
                        .toArray())
                .orElseGet(() -> new int[0]);
    }

    //  int[]转Integer[]
    public static Integer[] convertToWrapper(int[] primitiveArray) {
        return Optional.ofNullable(primitiveArray)
                .map(arr -> Arrays.stream(arr)
                        .boxed()
                        .toArray(Integer[]::new))
                .orElseGet(() -> new Integer[0]);
    }

    /**
     * 将字符串形式的数组转换为指定类型的数组
     * 例如: "[1,2,3]" -> {1,2,3}
     *
     * @param str   输入字符串，格式为 "[element1,element2,...]"，例如 "[1,2,3]"
     * @param clazz 目标数组元素类型，例如 Integer.class
     * @param <T>   泛型类型参数
     * @return 转换后的泛型数组，例如 {1, 2, 3}
     */
    public static <T> T[] string2Array(String str, Class<T> clazz) {
        if (str == null || str.isEmpty()) {
            return (T[]) Array.newInstance(clazz, 0);
        }
        String[] strArray = str.replaceAll("[\\[\\]]", "").split(",");
        T[] result = (T[]) Array.newInstance(clazz, strArray.length);
        return result;
    }

    /**
     * 将字符串形式的数组转换为Integer数组
     *
     * @param str 输入字符串，格式为 "[1,2,3]"，例如 "[1, 2, 3]"
     * @return Integer数组，例如 {1, 2, 3}
     */
    public static Integer[] string2IntArray(String str) {
        if (str == null || str.isEmpty()) {
            return new Integer[0];
        }
        String[] strArray = str.replaceAll("[\\[\\]]", "").split(",");
        return Arrays.stream(strArray)
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    /**
     * 将字符串形式的数组转换为二维Integer数组
     *
     * @param str 输入字符串，格式为 "[[1,2,3],[4,5,6]]"，例如 "[[1, 2, 3], [4, 5, 6]]"
     * @return 二维Integer数组，例如 {{1, 2, 3}, {4, 5, 6}}
     */
    public static Integer[][] string2Int2DArray(String str) {
        // [[1,2,3],[4,5,6]]
        if (str == null || str.isEmpty()) {
            return new Integer[0][0]; // 返回空的二维数组
        }
        // 按照 "],[" 分割字符串，提取每个子数组
        String[] strArray = str.split("\\],\\[");
        return Arrays.stream(strArray)
                .map(s -> string2IntArray(s.replaceAll("[\\[\\]]", ""))) // 去除方括号并转换为一维数组
                .toArray(Integer[][]::new); // 转换为二维数组
    }

    /**
     * 将字符串形式的数组转换为二维Integer列表
     *
     * @param str 输入字符串，格式为 "[[1,2,3],[4,5,6]]"，例如 "[[1, 2, 3], [4, 5, 6]]"
     * @return 二维Integer列表，例如 [[1, 2, 3], [4, 5, 6]]
     */
    public static List<List<Integer>> string2Int2DList(String str) {
        Integer[][] arr = string2Int2DArray(str);
        List<List<Integer>> list = convertInt2DArrayToList(arr);
        return list;
    }

    /**
     * 将Integer数组转换为List<Integer>
     *
     * @param array Integer数组，例如 {1, 2, 3}
     * @return Integer列表，例如 [1, 2, 3]
     */
    public static List<Integer> convertIntArrayToList(Integer[] array) {
        return array == null ? new ArrayList<>() : Arrays.stream(array).collect(Collectors.toList());
    }

    /**
     * 将int数组转换为List<Integer>
     *
     * @param array int数组，例如 {1, 2, 3}
     * @return Integer列表，例如 [1, 2, 3]
     */
    public static List<Integer> convertIntArrayToList(int[] array) {
        return array == null ? new ArrayList<>() : Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    /**
     * 将二维int数组转换为List<List<Integer>>
     *
     * @param array 二维int数组，例如 {{1, 2, 3}, {4, 5, 6}}
     * @return 二维Integer列表，例如 [[1, 2, 3], [4, 5, 6]]
     */
    public static List<List<Integer>> convertInt2DArrayToList(Integer[][] array) {
        if (array == null) {
            return new ArrayList<>();
        }
        return Arrays.stream(array)
                .map(Array2ListUtil::convertIntArrayToList)
                .collect(Collectors.toList());
    }

    /**
     * 将泛型数组转换为List
     * 注意：返回的List是固定大小的，不支持add/remove操作
     *
     * @param array 输入数组，例如 {1, 2, 3}
     * @param <T>   泛型类型参数
     * @return 固定大小的List，例如 [1, 2, 3]
     */
    public static <T> List<T> convertArrayToList(T[] array) {
        return array == null ? new ArrayList<>() : Arrays.asList(array);
    }

    /**
     * 将二维泛型数组转换为二维List
     * 注意：返回的内部List是固定大小的，不支持add/remove操作
     *
     * @param array 二维输入数组，例如 {{1, 2}, {3, 4}}
     * @param <T>   泛型类型参数
     * @return 包含固定大小List的可变List，例如 [[1, 2], [3, 4]]
     */
    public static <T> List<List<T>> convert2DArrayToList(T[][] array) {
        if (array == null) {
            return new ArrayList<>();
        }
        List<List<T>> result = new ArrayList<>();
        for (T[] subArray : array) {
            result.add(convertArrayToList(subArray));
        }
        return result;
    }
}

package graph;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.util.Map;

/**
 * @author avatarannappa
 * @version 1.0, 2023/3/5
 */
public class Convert {

    public static void main(String[] args) throws FileNotFoundException {
        String str = readFile("src/main/java/graph/1.json");
        JSONObject json = JSON.parseObject(str);
        System.out.println(json);
        Map<String, OldNode> map = JSON.parseObject(str, new TypeReference<Map<String, OldNode>>() {});
        System.out.println(map);
    }

    public static String readFile(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String laststr = "";
        try {
            // System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                laststr = laststr + tempString;
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return laststr;
    }
}

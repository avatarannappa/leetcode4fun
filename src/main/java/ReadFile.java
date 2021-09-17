import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.lang3.StringUtils;

/**
 * 读文件统计数据
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/14
 */
public class ReadFile {
    public static void main(String[] args) {
        String path = "~/IdeaProject/waimai_sc_c_api/src";
        File f = new File(path);
        recursion(f);
    }

    public static void recursion(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                File[] fileArray = f.listFiles();
                if (fileArray != null) {
                    for (int i = 0; i < fileArray.length; i++) {
                        recursion(fileArray[i]);
                    }
                }
            } else {
                if (f.getName().endsWith(".json")) {
                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new FileReader(f));
                        String tempString = null;
                        while ((tempString = reader.readLine()) != null) {
                            if (tempString.contains("ProxyAction")) {
                                System.out.println(f.getName() + " // " + StringUtils.trim(tempString));
                            }
                        }
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

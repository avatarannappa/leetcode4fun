package graph;

import java.util.Map;

/**
 * @author avatarannappa
 * @version 1.0, 2023/3/5
 */
public class OldJson {
    Map<String, OldNode> map;

    public Map<String, OldNode> getMap() {
        return map;
    }

    public void setMap(Map<String, OldNode> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "OldJson{" +
                "map=" + map +
                '}';
    }
}

package graph;

import java.util.List;

/**
 * @author avatarannappa
 * @version 1.0, 2023/3/5
 */
public class OldNode {
    private String className;
    private List<String> relay;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getRelay() {
        return relay;
    }

    public void setRelay(List<String> relay) {
        this.relay = relay;
    }

    @Override
    public String toString() {
        return "OldNode{" +
                "className='" + className + '\'' +
                ", relay=" + relay +
                '}';
    }
}

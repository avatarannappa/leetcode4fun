package graph;

import java.util.List;

/**
 * @author avatarannappa
 * @version 1.0, 2023/3/5
 */
public class NewJson {

    List<NewNode> nodeList;

    List<NewLine> lineList;

    public List<NewNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<NewNode> nodeList) {
        this.nodeList = nodeList;
    }

    public List<NewLine> getLineList() {
        return lineList;
    }

    public void setLineList(List<NewLine> lineList) {
        this.lineList = lineList;
    }

    @Override
    public String toString() {
        return "NewJson{" +
                "nodeList=" + nodeList +
                ", lineList=" + lineList +
                '}';
    }
}

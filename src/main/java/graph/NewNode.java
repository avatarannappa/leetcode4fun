package graph;

/**
 * @author avatarannappa
 * @version 1.0, 2023/3/5
 */
public class NewNode {
    String id;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NewNode{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

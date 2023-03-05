package graph;

/**
 * @author avatarannappa
 * @version 1.0, 2023/3/5
 */
public class NewLine {
    String from;
    String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "NewLine{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}

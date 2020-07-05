import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/5
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> list = new LinkedList<>();
    int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) {
            dfs(i);
        }
        System.out.println(list);
    }

    public void dfs(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            list.add(nestedInteger.getInteger());
            System.out.println(nestedInteger.getInteger());
        } else {
            List<NestedInteger> list = nestedInteger.getList();
            if (list.size() > 0) {
                for (NestedInteger i : list) {
                    dfs(i);
                }
            }
        }
    }

    @Override
    public Integer next() {
        Integer next = list.get(index);
        index++;
        return next;
    }

    @Override
    public boolean hasNext() {
        return list.size() != 0 && index < list.size() - 1;
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
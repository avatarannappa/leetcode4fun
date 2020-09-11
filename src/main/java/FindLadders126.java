import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 126. 单词接龙 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/11
 */
public class FindLadders126 {
    private static final int INF = 1 << 20;
    private Map<String, Integer> wordId = new HashMap<>();// 单词到id的映射
    private ArrayList<String> idWord = new ArrayList<>(); // id到单词的映射
    private ArrayList<Integer>[] edges; // 图的边

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        // 将wordList所有单词加入wordId中 相同的只保留一个 // 并为每一个单词分配一个id
        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, id++);
                idWord.add(word);
            }
        }
        // 若endWord不在wordList中 则无解
        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }
        // 把beginWord也加入wordId中
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }

        // 初始化存边用的数组
        edges = new ArrayList[idWord.size()];
        for (int i = 0; i < idWord.size(); i++) {
            edges[i] = new ArrayList<>();
        }
        // 添加边
        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                // 若两者可以通过转换得到 则在它们间建一条无向边
                if (oneWordDiff(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int dest = wordId.get(endWord); // 目的ID
        List<List<String>> res = new ArrayList<>(); // 存答案
        int[] cost = new int[id]; // 到每个点的代价
        for (int i = 0; i < id; i++) {
            cost[i] = INF; // 每个点的代价初始化为无穷大
        }

        // 将起点加入队列 并将其cost设为0
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;

        // 开始广度优先搜索
        while (!q.isEmpty()) {
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size() - 1); // 最近访问的点
            if (last == dest) { // 若该点为终点则将其存入答案res中
                ArrayList<String> tmp = new ArrayList<>();
                for (int index : now) {
                    tmp.add(idWord.get(index)); // 转换为对应的word
                }
                res.add(tmp);
            } else { // 该点不为终点 继续搜索
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    // 此处<=目的在于把代价相同的不同路径全部保留下来
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        // 把to加入路径中
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        q.add(tmp); // 把这个路径加入队列
                    }
                }
            }
        }
        return res;
    }

    //--------------------------------------------
    List<List<String>> result = new ArrayList<>();
    Set<String> globalSet = new HashSet<>();
    int level = Integer.MAX_VALUE;

    public List<List<String>> findLaddersDFS(String beginWord, String endWord, List<String> wordList) {
        // dfs 第21个case超时
        if (wordList == null || wordList.isEmpty()) {
            return result;
        }
        globalSet = new HashSet<>(wordList);
        if (!globalSet.contains(endWord)) {
            return result;
        }
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        recursion(beginWord, endWord, list);
        return result;
    }

    public void recursion(String begin, String end, List<String> list) {
        if (list.size() >= level) {
            return;
        }
        if (oneWordDiff(begin, end)) {
            list.add(end);
            if (list.size() < level) {
                result.clear();
                level = list.size();
            }
            result.add(list);
            return;
        }
        List<String> loopList = new ArrayList<>(globalSet);
        for (String s : loopList) {
            globalSet.remove(s);
            if (oneWordDiff(begin, s)) {
                List<String> newList = new ArrayList<>(list);
                newList.add(s);
                recursion(s, end, newList);
            }
            globalSet.add(s);
        }

    }

    public boolean oneWordDiff(String source, String target) {
        int diff = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(new FindLadders126().findLadders(beginWord, endWord, wordList));
    }
}

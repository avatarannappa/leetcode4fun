import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 355. 设计推特
 * medium
 *
 * @author avatarannappa
 * @date 2023/1/17
 */
public class Twitter355 {

    public Twitter355() {

    }

    int index = 0;
    public static class Node {

        int time;
        int tweetId;

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getTweetId() {
            return tweetId;
        }

        public void setTweetId(int tweetId) {
            this.tweetId = tweetId;
        }
    }

    Map<Integer, Set<Integer>> followMap = new HashMap<>();
    Map<Integer, Deque<Node>> postMap = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        Deque<Node> postList = postMap.getOrDefault(userId, new ArrayDeque<>());
        Node node = new Node();
        node.setTime(index++);
        node.setTweetId(tweetId);
        postList.addLast(node);
        if (postList.size() > 10) {
            postList.pollFirst();
        }
        postMap.put(userId, postList);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> foSet = followMap.getOrDefault(userId, new HashSet<>());
        PriorityQueue<Node> feedQueue = new PriorityQueue<>((o1, o2) -> o2.getTime() - o1.getTime());
        Deque<Node> myFeed = postMap.getOrDefault(userId, new ArrayDeque<>());
        feedQueue.addAll(myFeed);
        for (Integer fo : foSet) {
            Deque<Node> foFeed = postMap.getOrDefault(fo, new ArrayDeque<>());
            feedQueue.addAll(foFeed);
        }
        List<Integer> result = new LinkedList<>();
        int i = 0;
        while (!feedQueue.isEmpty() && (i++ < 10)) {
            result.add(feedQueue.poll().getTweetId());
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> foSet = followMap.getOrDefault(followerId, new HashSet<>());
        foSet.add(followeeId);
        followMap.put(followerId, foSet);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> foSet = followMap.getOrDefault(followerId, new HashSet<>());
        foSet.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter355 twitter = new Twitter355();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        System.out.println(twitter.getNewsFeed(1));
    }
}

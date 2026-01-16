class Twitter {
    private static int time = 0;

    HashMap<Integer, Set<Integer>> followees;
    HashMap<Integer, List<int[]>> tweets;

    public Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[] { time++, tweetId });
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        List<Integer> recents = new ArrayList<>();

        if (tweets.containsKey(userId)) {
            for (int[] t : tweets.get(userId)) {
                pq.offer(t);
            }
        }

        Set<Integer> fs = followees.getOrDefault(userId, new HashSet<>());

        for (int f : fs) {
            if (tweets.containsKey(f)) {
                for (int[] t : tweets.get(f)) {
                    pq.offer(t);
                }
            }
        }

        while (!pq.isEmpty() && recents.size() < 10) {
            recents.add(pq.poll()[1]);
        }
        return recents;

    }

    public void follow(int followerId, int followeeId) {
        followees.putIfAbsent(followerId, new HashSet<>());
        followees.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followees.containsKey(followerId))
            return;
        followees.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
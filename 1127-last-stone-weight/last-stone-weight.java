class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        Iterator value = pq.iterator();
        while (pq.size() > 1 && value.hasNext()) {
            int x = pq.poll();
            int y = pq.poll();

            if (x == y)
                continue;
            else
                pq.offer(x - y);
        }

        return pq.isEmpty() ? 0 : pq.poll();

    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < points.length; i++) {
            int dist = (points[i][0] * points[i][0]) +
                    (points[i][1] * points[i][1]);

            pq.offer(new int[] { dist, i });

            while (pq.size() > k)
                pq.poll();
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            ans[idx++] = points[node[1]];
        }
        return ans;
    }
}
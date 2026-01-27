class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n = intervals.length;
        int[][] ans = new int[n][2];
        int idx = 0;

        int x = intervals[0][0];
        int y = intervals[0][1];

        for (int i = 1; i < n; i++) {

            int r = intervals[i][0];
            int c = intervals[i][1];

            if (r <= y) {
                y = Math.max(y, c);
            } else {
                ans[idx][0] = x;
                ans[idx][1] = y;
                idx++;
                x = r;
                y = c;
            }
        }
        ans[idx][0] = x;
        ans[idx][1] = y;
        idx++;

        return Arrays.copyOf(ans, idx);

    }
}
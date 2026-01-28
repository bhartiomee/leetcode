class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] ans = new int[n+1][2];
        int m = newInterval.length;
        int idx = 0;
        int i = 0;

        while (i < n && newInterval[0] > intervals[i][1]) {
            ans[idx++] = intervals[i];
            i++;
        }
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        ans[idx++] = newInterval;

        while (i < n) {
            ans[idx++] = intervals[i];
            i++;
        }

        return Arrays.copyOf(ans,idx);
    }
}
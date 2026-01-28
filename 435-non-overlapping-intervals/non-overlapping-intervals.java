class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int n=intervals.length;
        int i = 0, j = 1;

        while (i < j && j < n) {
            while (j<n && intervals[j][0] < intervals[i][1]) {
                ans++;
                j++;
            }
            i=j;
            j++;
        }
        return ans;

    }
}
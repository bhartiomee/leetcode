class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = 0;

        for (int i = 0; i < n; i++) {
            high = Math.max(high, piles[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean takingMoreTime = timeToFinish(piles, mid, h);

            if (takingMoreTime)
                low = mid + 1;
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean timeToFinish(int[] piles, int k, int h) {
        int hour = 0;

        for (int i = 0; i < piles.length; i++) {
            hour += Math.ceil((double) piles[i] / k);
            if (hour > h)
                return true;
        }
        return (hour > h);
    }
}
class Solution {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            while (arr[i] <= n && arr[i] > 0 && arr[arr[i] - 1] != arr[i]) {
                int correctIdx = arr[i] - 1;

                int tmp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i + 1 != arr[i]) {
                return i + 1;
            }
        }

        return n + 1;

    }
}
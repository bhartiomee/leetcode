class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int pivot = -1;
        int j = 0;

        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                pivot = i - 1;
                break;
            }
        }

        if (pivot != -1) {
            for (int i = n - 1; i > pivot; i--) {
                if (arr[i] > arr[pivot]) {
                    swap(i, pivot, arr);
                    break;
                }
            }
        }

        reverse(pivot + 1, n - 1, arr);
    }

    private void reverse(int start, int end, int[] arr) {
        while (start < end) {
           swap(start,end,arr);
            start++;
            end--;
        }
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
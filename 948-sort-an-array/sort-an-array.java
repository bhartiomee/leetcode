class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        int mid;
        if (left < right) {
            mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }

    }

    private void merge(int[] nums, int left, int mid, int right) {
        int l = mid - left + 1;
        int r = right - mid;

        int[] la = new int[l];
        int[] ra = new int[r];

        for (int i = 0; i < l; i++) {
            la[i] = nums[left + i];
        }
        for (int i = 0; i < r; i++) {
            ra[i] = nums[mid + i + 1];
        }

        int li = 0, ri = 0, k = left;

        while (li < l && ri < r) {
            if (la[li] <= ra[ri]) {
                nums[k++] = la[li++];
            } else {
                nums[k++] = ra[ri++];
            }
        }

        while (li < l)
            nums[k++] = la[li++];
        while (ri < r)
            nums[k++] = ra[ri++];

    }
}
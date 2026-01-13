class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;

        int pivot = findPivot(nums);
        if (nums[pivot] == target)
            return pivot;

        int left = bs(nums, 0, pivot - 1, target);
        int right = bs(nums, pivot + 1, n - 1, target);

        if (left != -1)
            return left;
        else
            return right;

    }

    private int bs(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;

    }
}
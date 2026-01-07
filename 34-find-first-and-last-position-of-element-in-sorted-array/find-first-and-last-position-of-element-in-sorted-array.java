class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        ans[0] = firstOcc(nums, target);
        ans[1] = lastOcc(nums, target);

        return ans;
    }

    private int firstOcc(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                res = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private int lastOcc(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                res = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1}; // Default result if target is not found
        if (nums == null || nums.length == 0) {
            return result;
        }

        result[0] = findFirstPosition(nums, target);
        if (result[0] != -1) {
            result[1] = findLastPosition(nums, target);
        }

        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int firstPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                firstPos = mid; // Found target, but continue searching left
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstPos;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int lastPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                lastPos = mid; // Found target, but continue searching right
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastPos;
    }
}

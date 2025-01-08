class Solution {

     private int findRotationIndex(int[] nums) {

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {

      int mid = (left + right) / 2;
      if (mid == right) {
        return mid;
      }
      if (nums[mid + 1] < nums[mid])
        return mid;

      if (nums[left] <= nums[mid]) {
        left = mid + 1;
      } else
        right = mid - 1;
    }

    return -1;
  }

  private int binarySearch(int[] arr, int left, int right, int target) {

    while (left <= right) {
      int mid = (left + right) / 2;
      if (arr[mid] == target)
        return mid;

      if (arr[mid] < target) {
        left = mid + 1;
      } else
        right = mid - 1;
    }

    return -1;
  }

  private int modifiedBinarySearch(int[] arr, int target, int left, int right) {

    // Not found
    if (left > right)
      return -1;

    // Avoid overflow, same as (left + right)/2
    int mid = left + ((right - left) / 2);
    if (arr[mid] == target)
      return mid; // Found

    // If left half is sorted
    if (arr[mid] >= arr[left]) {

      // If key is in left half
      if (arr[left] <= target && target <= arr[mid])
        return modifiedBinarySearch(arr, target, left, mid - 1);
      else
        return modifiedBinarySearch(arr, target, mid + 1, right);

    } else {
      // If right half is sorted

      // If key is in right half
      if (arr[mid] <= target && target <= arr[right])
        return modifiedBinarySearch(arr, target, mid + 1, right);
      else
        return modifiedBinarySearch(arr, target, left, mid - 1);
    }
  }
    public int search(int[] nums, int target) {
        
          int rotationIndex = findRotationIndex(nums);

    if (rotationIndex == -1 || rotationIndex == nums.length - 1)
      return binarySearch(nums, 0, nums.length - 1, target);

    if (nums[0] <= target) {
      return binarySearch(nums, 0, rotationIndex, target);
    } else
      return binarySearch(nums, rotationIndex + 1, nums.length - 1, target);
  }

 
  public int alternateSearch(int[] nums, int target) {
    return modifiedBinarySearch(nums, target, 0, nums.length - 1);
    }
}
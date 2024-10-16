import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;
        
        // Merge the two sorted arrays into one
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        
        // Copy remaining elements of nums1, if any
        while (i < m) {
            temp[k++] = nums1[i++];
        }
        
        // Copy remaining elements of nums2, if any
        while (j < n) {
            temp[k++] = nums2[j++];
        }
        
        int size = m + n;
        
        // If the total size is odd, return the middle element
        if (size % 2 != 0) {
            return temp[size / 2];
        }
        
        // If the total size is even, return the average of the two middle elements
        return (temp[size / 2] + temp[(size / 2) - 1]) / 2.0;
    }
}

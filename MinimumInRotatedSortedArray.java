// Find Minimum in Rotated Sorted Array

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// You may assume no duplicate exists in the array.

class Solution {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return -1;
        
        int low = 0, high = nums.length -1;
        while(high - low >= 2){
            int mid = (high+low)/2;
            if(nums[mid] > nums[high] && nums[mid] > nums[low]){
                low = mid;
            }
            else
                high = mid;
        }
        return Math.min(nums[high], nums[low]);
    }
}
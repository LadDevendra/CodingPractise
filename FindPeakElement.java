//  Find Peak Element

//  A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that num[-1] = num[n] = -∞.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.


class Solution {
    public int findPeakElement(int[] nums) {
     
        int start =0, end = nums.length-1;
        while(start<end){
            int mid = (start+end)/2;
            
            if(nums[mid] < nums[mid+1])
                //we could skip mid coz its smaller that next element so cant be a peak
                start = mid+1;
            else
                //we can not skip mid coz its greater that next element so is a possible candidate for being peak
                end = mid;
        }
        return start;
    }
}

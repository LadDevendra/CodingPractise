// Longest Increasing Subsequence

// Given an unsorted array of integers, find the length of longest increasing subsequence.

// For example,
// Given [10, 9, 2, 5, 3, 7, 101, 18],
// The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

// Your algorithm should run in O(n2) complexity.

// Follow up: Could you improve it to O(n log n) time complexity?

class Solution {
    public int lengthOfLIS(int[] nums) {
        //DP solution - O(n^2)
        if(nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] DP = new int[len];
        //since every element is increasing subsequence of length 1
        Arrays.fill(DP, 1);
        
        for(int i = 1; i < len; i++){
            for(int j = 0; j< i; j++){
                if(nums[i] > nums[j])
                    DP[i] = Math.max(DP[i], DP[j] + 1);
            }
        }
        int maxIndex = 0;
        for(int i =1; i< len; i++)
            if(DP[i] > DP[maxIndex])
                maxIndex = i;
        
        return DP[maxIndex];
        
        //DP with optimization solution - O(n Log(n))
        
    }
}
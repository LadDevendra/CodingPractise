// House Robber

// ote: This is an extension of House Robber.

// After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.



class Solution {
    public int rob(int[] nums) {
        int max = 0;
        if(nums.length < 2){
            for(int i = 0; i< nums.length; i++){
                max = Math.max(nums[i], max);
            }
        return max;
        }else
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
    public int rob(int[] nums, int start, int end) {
        int rob = 0, notRob = 0;
        for(int i = start; i<= end; i++){
            int temp = nums[i] + notRob; //robbing current house! -> currMoney + Not Robbing last house
            notRob = Math.max(rob, notRob); //Not Robbing curr House -> Robbing last OR not robbing last.
            rob = temp;
        }
        return Math.max(rob, notRob);
    }
}
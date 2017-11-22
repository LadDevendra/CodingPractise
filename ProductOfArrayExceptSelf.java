// //PProduct of Array Except Self

// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

// Follow up:
// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //two pass algorithm..  answer[curr] = (0->n-1 product before current) * (n-1->0 product after current)
        if(nums == null || nums.length == 0)
            return null;
        int len = nums.length;
        int[] result = new int[len];
        //first pass
        result[0] = 1;
        for(int i=1; i<len; i++){
            result[i] = result[i-1] * nums[i-1];
        }
        //second pass
        int currProduct = 1;
        for(int i = len-2; i>=0; i--){
            currProduct = currProduct* nums[i+1];
            result[i] *= currProduct;
        }
        return result;
    }
}
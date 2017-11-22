// Sort Colors

// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note:
// You are not suppose to use the library's sort function for this problem.

// click to show follow up.

// Follow up:
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

// Could you come up with an one-pass algorithm using only constant space?


class Solution {
    public void sortColors(int[] nums) {
        //counting sort O(n) Two passes in array
            // int cred = 0, cwhite = 0, cblue = 0;
            // for(int i : nums){
            //     if(i == 0) cred++;
            //     if(i == 1) cwhite++;
            //     if(i == 2) cblue++;
            // }
            // int i = 0;
            // while(cred > 0){
            //  nums[i++] = 0;
            //     cred--;
            // }
            // while(cwhite > 0){
            //     nums[i++] = 1;
            //     cwhite--;
            // }
            // while(cblue > 0){
            //     nums[i++] = 2;   
            //     cblue--;
            // }
        
        //O(n) One pass solution
        //little complicated, three pointer approach.index ptr AND One pointer each for 0's and 2's and running adjustment for middle elements
        if(nums == null || nums.length == 0)
            return;
        int len = nums.length;
        int index = 0, ptr0 = 0, ptr2 = len -1;
        
        while(index <= ptr2){
            if(nums[index] == 0){
                nums[index] = nums[ptr0];
                nums[ptr0++] = 0;
            }
            if(nums[index] == 2){
                nums[index] = nums[ptr2];
                nums[ptr2--] = 2;
                index--;
            }
            index++;
        }
    }
}
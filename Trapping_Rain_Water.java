//  Trapping Rain Water

//  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

class Solution {
    public int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        //sum of amount of water over each tower is final answer sum(Wi);
        //Wi is Max(0, Math.min(maxSeenLeft, maxSeenRight)- currHeight);
        //optimization...for maxSeenLeft we can just keep running maxSeenLeft.. where as for right we store in array.
        //lets go!!
        int result = 0, len = height.length;
        int[] maxSeenRight = new int[len];
        maxSeenRight[len-1] = height[len-1];
        //fill using DP
        for(int i = len-2; i>=0; i--)
            maxSeenRight[i] = Math.max(height[i], maxSeenRight[i+1]);
        int maxSeenLeft = height[0];
        
        for(int i=1; i<len-1; i++){
            result += Math.max(0, Math.min(maxSeenRight[i], maxSeenLeft) - height[i]);
            maxSeenLeft = Math.max(maxSeenLeft, height[i]);
        }
        return result;
    }
}
// Median of Two Sorted Arrays
// There are two sorted arrays nums1 and nums2 of size m and n respectively.

// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

// Example 1:
// nums1 = [1, 3]
// nums2 = [2]

// The median is 2.0
// Example 2:
// nums1 = [1, 2]
// nums2 = [3, 4]

// The median is (2 + 3)/2 = 2.5



class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //variant of binary search O(min(m,n))
        if(nums1 == null || nums2 == null)
            return -1;  //ask interviwer what to do!!
        int len1 = nums1.length;
        int len2 = nums2.length;
        //make sure nums1 is smaller array.
        if(len1 > len2)
            return findMedianSortedArrays(nums2, nums1);
            
        
        //Now we binary search in n1;
        int start =0, end = len1;
        int partitionX = 0, partitionY = 0;
        
        while(start <= end){
            //partitionX/Y are right inclusive, means if partitionX = 2 Means [0, 1] & [2, 3, 4] indices are partitioned
            partitionX =  (start+end)/2;   
            partitionY = (len1+len2+1)/2 - partitionX;
            
            int maxLeftX = partitionX == 0? Integer.MIN_VALUE: nums1[partitionX-1];
            int minRightX = partitionX == len1? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = partitionY == 0? Integer.MIN_VALUE: nums2[partitionY-1];
            int minRightY = partitionY == len2? Integer.MAX_VALUE : nums2[partitionY];
            
            //all on left side are smaller than all on right side! perfect partition.
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                //found the perfect partition..
                if((len1+len2) % 2 == 1)
                    return (double)Math.max(maxLeftX, maxLeftY);
                else
                    return (Math.max(maxLeftX, maxLeftY) + 
                                Math.min(minRightX, minRightY)) / 2.0;
            }
            else if(maxLeftX > minRightY){
                //need to move on left
                end = partitionX -1;
            }
            else
                //need to move on right
                start = partitionX +1;
        }
    //if Arrays are not sorted!!
       return -1; 
    }
}
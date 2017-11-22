// Kth Largest Element in an Array

// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ array's length.

// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //priority queue O(nlogK)
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int i: nums){
//             pq.offer(i);
            
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }
//         return pq.peek();
        
        //using partition approach like quick sort 
        shuffle(nums);
        k = nums.length - k;
        int l = 0, h = nums.length -1;
        while(l<=h){
            int j = partition(nums, l, h);
            if(j<k){
                l = j+1;
            }else if(j>k){
                h = j-1;
            }else{
                break;
            }
        }
        return nums[k];
    }
    
     private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
    
    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

}
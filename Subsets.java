// Subsets

// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        //Non recursive approach
//                     if(nums==null)
//                         return null;

//                     Arrays.sort(nums);
//                     List<List<Integer>> result =  new ArrayList<>();

//                     for(int i = 0; i< nums.length; i++){
//                         List <List<Integer>> temp = new ArrayList<>();

//                         //get already added arrays and put em in temp AS A ONE LIST EACH
//                         for(List<Integer> a: result)
//                             temp.add(new ArrayList<Integer>(a));

//                         //add s[i] to each and every one of em
//                         for(List<Integer> a: temp)
//                             a.add(nums[i]);

//                         //add only s[i] as a list
//                         ArrayList<Integer> single = new ArrayList<Integer>();
//                         single.add(nums[i]);
//                         temp.add(single);

//                         //add all sets from temp to result
//                         result.addAll(temp);
//                     }
//                     //add empty
//                     result.add(new ArrayList<Integer>());
//                     return result;
        
        //Backtracking approach
            // Arrays.sort(nums);
            // List<List<Integer>> result = new ArrayList<>();
            // backtrack(result, new ArrayList<Integer>(), nums, 0);
            // return result;
    
        // public void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start){
        //     result.add(new ArrayList<>(tempList));
        //     for(int i= start; i< nums.length; i++){
        //         //remove duplicates
        //         if(i>start && nums[i] == nums[i-1]) continue;
        //         //choose
        //         tempList.add(nums[i]);
        //         //explore
        //         backtrack(result, tempList, nums, i+1);
        //         //remove
        //         tempList.remove(tempList.size()-1);
        //     }
}
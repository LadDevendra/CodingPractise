// Permutations 2

// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null)
            return res;
        //to handle duplicates they should be one after other..
        Arrays.sort(nums);
        permuteHelper(nums, res, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }
    public void permuteHelper(int[] nums, List<List<Integer>> res, List<Integer> tempList, boolean[] used){
        if(tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            if(i> 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            permuteHelper(nums, res, tempList, used);
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }
}
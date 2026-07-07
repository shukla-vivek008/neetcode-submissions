class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if(mpp.containsKey(diff)) {
                return new int[] {mpp.get(diff), i};
            }
            mpp.put(num, i);
        }
        
        return new int[] {};
    }
}

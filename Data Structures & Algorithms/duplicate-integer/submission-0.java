class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int val = 0;
        for(int n : nums) {
            if(mpp.containsKey(n)) {
                return true;
            }
            mpp.putIfAbsent(n, val);
        }
        return false;
    }
}
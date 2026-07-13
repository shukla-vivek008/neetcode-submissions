class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();

        int count = 0, sum = 0;

        mpp.put(0, 1);
        for (int num : nums) {
            sum += num;
            int left = sum - k;

            if (mpp.containsKey(left)) {
                count += mpp.get(left);
            }

            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
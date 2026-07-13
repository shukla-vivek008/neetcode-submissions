class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int it : set) {
            if (!set.contains(it - 1)) {
                int x = it;
                int count = 1;
                while (set.contains(x + 1)) {
                    count++;
                    x++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}

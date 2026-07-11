class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[n + 1];

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i <= n; i++) {
            if (bucket[i] == null)
                bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            bucket[e.getValue()].add(e.getKey());
        }

        int res[] = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i > 0 && index < k; i--) {
            for (int it : bucket[i]) {
                res[index++] = it;
                if (index == k)
                    return res;
            }
        }
        return res;
    }
}

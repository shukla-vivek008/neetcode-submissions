class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[left];
                    sum += nums[right];

                    if (sum == target) {
                        List<Integer> temp =
                            Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        ls.add(temp);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;

                    } else if (sum > target)
                        right--;
                    else {
                        left++;
                    }
                }
            }
        }

        return ls;
    }
}
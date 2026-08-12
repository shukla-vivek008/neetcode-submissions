class Solution {
    public int countArray(int[] nums, int maxSum) {
        int subArray = 1, curSum = 0;
        for(int n : nums) {
            if(curSum + n > maxSum) {
                subArray++;
                curSum = n;
            } else {
                curSum += n;
            }
        }
        return subArray;
    }
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int subArray = countArray(nums, mid);
            if(subArray > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

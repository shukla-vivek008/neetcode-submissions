class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n == 0 ) return 0;

        int ele = nums[0];
        int count = 1;

        for(int i = 1; i < n; i++) {
            if(count == 0) {
                ele = nums[i];
            }
            if(ele == nums[i]){
                count++;
            } else{
                count--;
            }
        }
        if(count > 0) return ele;

        return 0;
    }
}
class Solution {
    public int maxArea(int[] h) {
        int n = h.length;

        int left = 0 , right = n-1;
        int res = 0;

        while(left < right) {
            int area = Math.min(h[left], h[right]) * (right - left);
            res = Math.max(area, res);
            if(h[left] <= h[right]) left++;
            else right--;
        }

        return res;
    }
}

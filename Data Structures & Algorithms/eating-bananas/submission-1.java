class Solution {
    public int calTime(int[] piles, int speed) {
        int totalTime = 0;
        for(int banana : piles) {
            totalTime += (int) Math.ceil((double) banana / speed);
        }
        return totalTime;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();

        while(low <= high) {
            int mid = (low + high) / 2;
            int timeReq = calTime(piles, mid);
            if(timeReq <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

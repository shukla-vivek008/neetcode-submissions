class Solution {
    public int dayNeeded(int[] weights, int capacity) {
        int currLoad = 0, day = 1;
        for(int w : weights) {
            if(currLoad + w > capacity) {
                day++;
                currLoad = w;
            } else {
                currLoad += w;
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        for(int capacity = low; capacity < high; capacity++) {
            int req = dayNeeded(weights, capacity);
            
            if(req <= days) return capacity;
        }
        return high;
    }
}
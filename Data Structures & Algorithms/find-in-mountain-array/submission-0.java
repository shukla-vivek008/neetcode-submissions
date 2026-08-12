/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        int peak = findPeak(mountainArr);

        int low = 0;
        int high = peak - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int value = mountainArr.get(mid);
            if (value > target)
                high = mid - 1;
            else if (value < target)
                low = mid + 1;
            else
                return mid;
        }

        low = peak;
        high = length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int value = mountainArr.get(mid);
            if (value < target)
                high = mid - 1;
            else if (value > target)
                low = mid + 1;
            else
                return mid;
        }

        return -1;
    }

    public int findPeak(MountainArray mountainArr) {
        int length = mountainArr.length();

        int low = 1, high = length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            int left = mountainArr.get(mid - 1);
            int check = mountainArr.get(mid);
            int right = mountainArr.get(mid + 1);

            if (left < check && check < right)
                low = mid + 1;
            else if (left > check && check > right)
                high = mid - 1;
            else {
                return mid;
            }
        }
        return -1;
    }
}
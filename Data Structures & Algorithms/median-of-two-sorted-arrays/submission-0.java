class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int smallerLength = nums1.length;
        int largerLength = nums2.length;

        int low = 0;
        int high = smallerLength;

        int leftPartitionSize = (smallerLength + largerLength + 1) / 2;
        int totalLength = smallerLength + largerLength;

        while (low <= high) {
            int partition1 = (low + high) / 2;

            int partition2 = leftPartitionSize - partition1;

            int leftMax1 = partition1 > 0
                    ? nums1[partition1 - 1]
                    : Integer.MIN_VALUE;

            int leftMax2 = partition2 > 0
                    ? nums2[partition2 - 1]
                    : Integer.MIN_VALUE;

            int rightMin1 = partition1 < smallerLength
                    ? nums1[partition1]
                    : Integer.MAX_VALUE;

            int rightMin2 = partition2 < largerLength
                    ? nums2[partition2]
                    : Integer.MAX_VALUE;

            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {

                if (totalLength % 2 != 0) {
                    return Math.max(leftMax1, leftMax2);
                }

                int leftSideMax = Math.max(leftMax1, leftMax2);
                int rightSideMin = Math.min(rightMin1, rightMin2);

                return (leftSideMax + rightSideMin) / 2.0;
            }

            if (leftMax1 > rightMin2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }

        return 0.0;
    }
}
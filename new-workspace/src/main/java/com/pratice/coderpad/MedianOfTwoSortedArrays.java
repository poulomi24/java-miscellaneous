package com.pratice.coderpad;

// find the median of the two sorted arrays.
// ex. {1, 3} and {2} is 2
public class MedianOfTwoSortedArrays {

        public static double logic(int[] nums1, int[] nums2) {
            int totalLength = nums1.length + nums2.length;
            int[] merged = new int[totalLength];
            int i = 0, j = 0, k = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    merged[k++] = nums1[i++];
                } else {
                    merged[k++] = nums2[j++];
                }
            }

            while (i < nums1.length) {
                merged[k++] = nums1[i++];
            }

            while (j < nums2.length) {
                merged[k++] = nums2[j++];
            }

            if (totalLength % 2 == 0) {
                int mid = totalLength / 2;
                return (merged[mid - 1] + merged[mid]) / 2.0;
            } else {
                int mid = totalLength / 2;
                return merged[mid];
            }
    }

        public static boolean pass()
        {
            boolean result = true;
            result = result && logic(new int[]{1, 3, 6}, new int[]{2, 4}) == 3;
            return result;
        };

        public static void main(String[] args)
        {
            if(pass())
            {
                System.out.println("pass");
            }
            else
            {
                System.out.println("some failures");
            }
        }
}

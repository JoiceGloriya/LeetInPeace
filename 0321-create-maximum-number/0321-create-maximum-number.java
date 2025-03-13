class Solution {
    int[] maxArray(int[] nums, int k) { //top-k elements from nums
        int[] ans = new int[k];
        int n = nums.length;
        int j = 0;
        for(int i = 0; i < n; i ++) {
            while(n - i + j > k && j > 0 && ans[j - 1] < nums[i]) 
                j--;
            if(j < k) ans[j++] = nums[i];
        }
        return ans;
    }

    int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;
        for(int r = 0; r < k; r ++) {
            ans[r] = findGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    boolean findGreater(int[] nums1, int i, int[] nums2, int j) {
        int n = nums1.length;
        int m = nums2.length;
        while(i < n && j < m && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return (j == m) || (i < n && nums1[i] > nums2[j]);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] best = new int[k];
        for(int i = Math.max(0, k - m); i <= Math.min(k, n); i ++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if(findGreater(candidate, 0, best, 0))
                best = candidate;
        }
        return best;

    }
}
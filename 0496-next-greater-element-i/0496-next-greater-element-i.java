class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //Using a monotonic stack in a decreasing order [light poles intuition!!]
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];

        Map<Integer, Integer> mpp = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        for(int i = n2 - 1; i >= 0; i --) {
            while(!stk.isEmpty() && nums2[i] > stk.peek())
                stk.pop();
            if(stk.isEmpty())
                mpp.put(nums2[i], -1);
            else 
                mpp.put(nums2[i], stk.peek());
            stk.push(nums2[i]);
        }
        for(int i = 0; i < n1; i ++)
            ans[i] = mpp.get(nums1[i]);

        return ans;


    }
}
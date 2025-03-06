class Solution {
    public long subArrayRanges(int[] nums) {
        long total = sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
        return total;
    }

    public long sumSubarrayMaxs(int[] arr) {
        long sum = 0;
        int[] nge = findNge(arr);
        int[] pgee = findPgee(arr);
        for (int i = 0; i < arr.length; i++) {
            long left = i - pgee[i];
            long right = nge[i] - i;
            sum += right * left * arr[i];
        }
        return sum;
    }

    public long sumSubarrayMins(int[] arr) {
        long sum = 0;
        int[] nse = findNse(arr);
        int[] psee = findPsee(arr);
        for (int i = 0; i < arr.length; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            sum += right * left * arr[i];
        }
        return sum;
    }

    public int[] findNse(int[] arr) {
        int[] nse = new int[arr.length];
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();
            nse[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] findPsee(int[] arr) {
        int[] psee = new int[arr.length];
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            psee[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    public int[] findNge(int[] arr) {
        int[] nge = new int[arr.length];
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            nge[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    public int[] findPgee(int[] arr) {
        int[] pgee = new int[arr.length];
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pgee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pgee;
    }
}

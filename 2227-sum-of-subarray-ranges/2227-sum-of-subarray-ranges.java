// class Solution {
//     public long subArrayRanges(int[] nums) {
//         long subarrayMini = subarrayMin(nums);
//         long subarrayMaxi = subarrayMax(nums);
//         long mod = 1000000007L;
//         long difference = subarrayMaxi - subarrayMini;
//         return (difference % mod + mod) % mod;
//     }

//     long subarrayMin(int[] nums) {
//         int[] psee = findPSEE(nums);
//         int[] nse = findNSE(nums);
//         long total = 0;
//         long mod = 1000000007L;

//         for (int i = 0; i < nums.length; i++) {
//             int left = i - psee[i];
//             int right = nse[i] - i;
//             long value = (left * right * (long) nums[i]) % mod;
//             total = (total + value) % mod;
//         }

//         return total;
//     }

//     long subarrayMax(int[] nums) {
//         int[] pgee = findPGEE(nums);
//         int[] nge = findNGE(nums);
//         long total = 0;
//         long mod = 1000000007L;

//         for (int i = 0; i < nums.length; i++) {
//             int left = i - pgee[i];
//             int right = nge[i] - i;
//             long value = (left * right * (long) nums[i]) % mod;
//             total = (total + value) % mod;
//         }

//         return total;
//     }

//     int[] findNGE(int[] nums) {
//         Stack<Integer> stk = new Stack<>();
//         int[] nge = new int[nums.length];

//         for (int i = nums.length - 1; i >= 0; i--) {
//             while (!stk.isEmpty() && nums[i] > nums[stk.peek()])
//                 stk.pop();
//             nge[i] = stk.isEmpty() ? nums.length : stk.peek();
//             stk.push(i);
//         }
//         return nge;
//     }

//     int[] findPGEE(int[] nums) {
//         Stack<Integer> stk = new Stack<>();
//         int[] pgee = new int[nums.length];

//         for (int i = 0; i < nums.length; i++) {
//             while (!stk.isEmpty() && nums[i] >= nums[stk.peek()])
//                 stk.pop();
//             pgee[i] = stk.isEmpty() ? -1 : stk.peek();
//             stk.push(i);
//         }
//         return pgee;
//     }

//     int[] findNSE(int[] nums) {
//         Stack<Integer> stk = new Stack<>();
//         int[] nse = new int[nums.length];

//         for (int i = nums.length - 1; i >= 0; i--) {
//             while (!stk.isEmpty() && nums[i] < nums[stk.peek()])
//                 stk.pop();
//             nse[i] = stk.isEmpty() ? nums.length : stk.peek();
//             stk.push(i);
//         }
//         return nse;
//     }

//     int[] findPSEE(int[] nums) {
//         Stack<Integer> stk = new Stack<>();
//         int[] psee = new int[nums.length];

//         for (int i = 0; i < nums.length; i++) {
//             while (!stk.isEmpty() && nums[i] <= nums[stk.peek()])
//                 stk.pop();
//             psee[i] = stk.isEmpty() ? -1 : stk.peek();
//             stk.push(i);
//         }
//         return psee;
//     }
// }

class Solution {
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

    public int[] findNge(int[] arr) {
        int[] nge = new int[arr.length];
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i])
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
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            pgee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pgee;
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

    public long subArrayRanges(int[] nums) {
        long total = sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
        return total;
    }
}

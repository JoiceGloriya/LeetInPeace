class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pref = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
            pref[i][j] = (i > 0 ? pref[i - 1][j] : 0) + 1;
        } else {
            pref[i][j] = 0;
        }
            }
        }
        for (int i = 0; i < m; i++)
            maxArea = Math.max(maxArea, lHistogram(pref[i]));
        return maxArea;
    }

    int lHistogram(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                int index = stk.pop();
                int nse = i;
                int pse = stk.isEmpty() ? -1 : stk.peek();
                maxLen = Math.max(maxLen, arr[index] * (nse - pse - 1));
            }
            stk.push(i);
        }

        while (!stk.isEmpty()) {
            int index = stk.pop();
            int nse = n;
            int pse = stk.isEmpty() ? -1 : stk.peek();
            maxLen = Math.max(maxLen, arr[index] * (nse - pse - 1));
        }
        return maxLen;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        // Optimal approach without any pre-computation of nse[] and pse[]
        //while traversing in forward direction itself, i can get hold of pse as well as nse cuz, if i wanna pop an element inorder to make the stk strictly increasing (which is essential in case of pse) it means that the ith element is nse of the element that I wanna pop! 
        Stack<Integer> stk = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i ++) {
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                int index = stk.pop();
                int nse = i;
                int pse = stk.isEmpty() ? -1 : stk.peek();
                maxArea = Math.max(maxArea, (heights[index] * (nse - pse -1)));
            }
            stk.push(i);
        }

        while(!stk.isEmpty()) {
            int index = stk.pop();
            int nse = heights.length;
            int pse = stk.isEmpty() ? -1 : stk.peek();
            maxArea = Math.max(maxArea, (heights[index] * (nse - pse -1)));
        }

        return maxArea;
    }
}
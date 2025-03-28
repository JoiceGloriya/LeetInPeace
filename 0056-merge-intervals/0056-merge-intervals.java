class Solution {
    public int[][] merge(int[][] intervals) {
        // Naive: TC -> O(N logN) + O(2N) SC -> O(N)

        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); //sort based
        // on first column
        // List<List<Integer>> list = new ArrayList<>();

        // for(int i = 0; i < intervals.length; i ++) {
        // int start = intervals[i][0];
        // int end = intervals[i][1];

        // if(!list.isEmpty() && end <= list.get(list.size()-1).get(1)) {
        // continue;
        // }

        // for(int j = i + 1; j < intervals.length; j ++) {
        // if(intervals[j][0] <= end)
        // end = Math.max(end, intervals[j][1]);
        // else break;
        // }

        // list.add(Arrays.asList(start, end));
        // }

        // int rows = list.size();
        // int[][] ans = new int[list.size()][2];
        // for(int i = 0; i < rows; i ++) {
        // for(int j = 0; j < 2; j ++) {
        // ans[i][j] = list.get(i).get(j);
        // }
        // }

        // return ans;

        // Optimal: TC -> O(N logN) + O(N) SC -> O(N)

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int[] arr : intervals) {
            if (arr[0] <= end)
                end = Math.max(end, arr[1]);
            else {
                list.add(new int[] { start, end });
                start = arr[0];
                end = arr[1];
            }
        }
        list.add(new int[] { start, end });

        return list.toArray(new int[list.size()][]);

    }
}
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(1, new ArrayList<>(), k, n, list);
        return list;
    }

    void backtrack(int startIndex, List<Integer> a, int k, int n, List<List<Integer>> list) {
        if (a.size() == k && n == 0) {
            list.add(new ArrayList<>(a));
            return;
        }
        if (a.size() == k)
            return;
        for (int i = startIndex; i <= 9; i++) {
            if (n - i >= 0) {
                a.add(i);
                backtrack(i + 1, a, k, n - i, list);
                a.remove(a.size() - 1);
            }
        }
    }
}
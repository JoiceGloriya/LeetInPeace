class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(1, new ArrayList<>(), k, n, list);
        return list;
    }
    
// TC -> O(2^9 * k) = O(512 * k) ~= O(k) where k is some constant <= 9 
// SC -> prd of number of combinations and size of each comb. O(2^9 * k) ~= O(k) k is some constant <= 9 and 'k' is recursive depth

    void backtrack(int startIndex, List<Integer> a, int k, int n, List<List<Integer>> list) {
        if (a.size() == k && n == 0) {
            list.add(new ArrayList<>(a));
            return;
        }
        if (a.size() == k)
            return;
        for (int i = startIndex; i <= 9; i++) {
            // if (n - i >= 0) {
                a.add(i);
                backtrack(i + 1, a, k, n - i, list);
                a.remove(a.size() - 1);
            // }
        }
    }
}

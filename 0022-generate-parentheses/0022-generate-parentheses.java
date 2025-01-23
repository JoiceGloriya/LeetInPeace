class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        DFS(list, "", 0, 0, n);
        return list;
    }

    void DFS(List<String> list, String str, int open, int close, int maxLimit) {
        if(str.length() == 2 * maxLimit) {
            list.add(str);
            return;
        }
        if(open < maxLimit) 
            DFS(list, str + "(", open + 1, close, maxLimit);
        if(close < open)
            DFS(list, str + ")", open, close + 1, maxLimit);
    }
}
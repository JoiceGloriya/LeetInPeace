class Solution {
    public List<String> letterCombinations(String digits) {
        // Time Complexity: O(4^n * n)
        // Space Complexity: O(4^n * n)
         
        List<String> list = new ArrayList<>();
        if(digits.isEmpty()) return list;
        StringBuilder a = new StringBuilder();
        String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(0, digits, a, list, keys);
        return list;
    }

    void backtrack(int startIndex, String digits, StringBuilder a, List<String> list, String[] keys) {
        if(startIndex == digits.length()) {
            list.add(String.valueOf(a));
            return;
        }
        String str = keys[digits.charAt(startIndex) - '0'];
        for(int i = 0; i < str.length(); i ++) {
            a.append(str.charAt(i));
            backtrack(startIndex + 1, digits, a, list, keys);
            a.deleteCharAt(a.length() - 1);
        }
    }
}
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        backtrack(0, num, 0L, 0L, target, "", list);
        return list;
    }

    void backtrack(int startIndex, String num, long sum, long prevNum, int target, String ans, List<String> list) {
        if (startIndex == num.length()) {
            if (sum == target) 
                list.add(new String(ans));
            return;
        }
        for (int i = startIndex; i < num.length(); i++) {
            if (i > startIndex && num.charAt(startIndex) == '0')
                break;
            long currNum = Long.parseLong(num.substring(startIndex, i + 1));
            if (startIndex == 0) {
                backtrack(i + 1, num, currNum, currNum, target, ans + currNum, list);
            } else {
                backtrack(i + 1, num, sum + currNum, currNum, target, (ans + "+" + currNum), list);
                backtrack(i + 1, num, sum - currNum, -currNum, target, (ans + "-" + currNum), list);
                backtrack(i + 1, num, ((sum - prevNum) + (prevNum * currNum)), (prevNum * currNum),  target, (ans + "*" + currNum), list);
            }
        }
    }
}
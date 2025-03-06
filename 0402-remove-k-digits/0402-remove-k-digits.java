class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stk.isEmpty() && k > 0 && num.charAt(i) - '0' < stk.peek() - '0') {
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
        }
        StringBuilder str = new StringBuilder();
        while (!stk.isEmpty() && k > 0) { // trim-off last 'k' numbers -> the stk would be of type '123456'
            stk.pop();
            k--;
        }
        if (stk.isEmpty())
            return "0";
        while (!stk.isEmpty()) {
            str = str.append(stk.pop());
        }
        while (str.length() != 0 && str.charAt(str.length() - 1) == '0') // trim-off leading zeroes
            str.deleteCharAt(str.length() - 1);
        if (str.length() == 0)
            return "0";
        reverse(str);
        return str.toString();
    }

    void reverse(StringBuilder str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            char temp = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, temp);

            start++;
            end--;
        }
    }
}
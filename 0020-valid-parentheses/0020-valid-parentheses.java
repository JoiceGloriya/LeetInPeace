class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stk.push(c);
            else if (!stk.isEmpty()) {
                if (c == ')' && stk.pop() != '(')
                    return false;
                else if (c == ']' && stk.pop() != '[')
                    return false;
                else if (c == '}' && stk.pop() != '{')
                    return false;
            } else
                return false;
        }
        if (!stk.isEmpty())
            return false;
        return true;
    }
}
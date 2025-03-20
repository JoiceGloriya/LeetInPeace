class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for(int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                min++;
                max++;
            }
            else if(ch == ')') {
                if(min >= 1) min --;
                if(max >= 1)
                    max--;
                else return false; 
            }
            else {
                if(min >= 1) min --;
                max++;
            }
        }
        return min == 0;
    }
}
class Solution {
    public static int myAtoi(String s) {
        if (s.isEmpty())
            return 0;
        int result = 0, sign = 1, i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ')
            i++;
        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if (i < n && s.charAt(i) == '+') {
            sign = 1;
            i++;
        }
        while (i < n && s.charAt(i) == '0')
            i++;
        for (; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                char c = s.charAt(i);
                if ((result > Integer.MAX_VALUE / 10)
                        || ((result == Integer.MAX_VALUE / 10) && (c - '0') > (Integer.MAX_VALUE % 10)))
                    return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                result = result * 10 + (c - '0');
            } else
                return result * sign;
        }
        return result * sign;
    }
}
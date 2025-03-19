class Solution {
    public boolean lemonadeChange(int[] bills) {
        int no_of_fives = 0, no_of_tens = 0, no_of_twenties = 0;
        if(bills[0] != 5) return false;
        for(int i = 0; i < bills.length; i ++) {
            if(bills[i] == 5)
                no_of_fives++;
            else if(bills[i] == 10) {
                no_of_tens++;
                if(no_of_fives > 0) no_of_fives --;
                else return false;
            }
            else {
                no_of_twenties++;
                if(no_of_fives >= 3 || (no_of_fives >= 1 && no_of_tens >= 1)) {
                    if(no_of_fives >= 1 && no_of_tens >= 1) {
                        no_of_fives--;
                        no_of_tens--;
                    }
                    else no_of_fives -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}
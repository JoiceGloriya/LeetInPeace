class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length, m = s.length;
        int l = 0, r = 0;
        while(l < m && r < n) {
            if(s[l] >= g[r]) {
                l++;
                r++;
            }
            else l++;
        }
        return r;
    }
}
class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        boolean[] visited = new boolean[26];
        int[] lastSeen = new int[26];
        Stack<Integer> stk = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i ++) 
            lastSeen[s.charAt(i) - 'a'] = i;
        for(int i = 0; i < n; i ++) {
            int index = s.charAt(i) - 'a';
            if(visited[index]) continue;
            while(!stk.isEmpty() && stk.peek() > index && i < lastSeen[stk.peek()]) 
                visited[stk.pop()] = false;
            stk.push(index);
            visited[index] = true;
        }
        for(int i = 0; !stk.isEmpty() && i < n; i ++) {
            str.append((char)(stk.pop() + 'a'));
        }
        return str.reverse().toString();
    }
}
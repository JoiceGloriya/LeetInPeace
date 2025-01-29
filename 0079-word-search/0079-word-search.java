class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                if (backtrack(i, j, board, word, 0))
                    return true;
        }
        return false;
    }

    boolean backtrack(int i, int j, char[][] board, String word, int index) {
        if (index == word.length())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;
        board[i][j] = '#'; // [marking curent cell as visited] to make sure that same char is not considered again
        boolean result = backtrack(i - 1, j, board, word, index + 1) || backtrack(i, j - 1, board, word, index + 1)
        || backtrack(i + 1, j, board, word, index + 1) || backtrack(i, j + 1, board, word, index + 1);
        board[i][j] = word.charAt(index); // [unmarking it] resetting the modified value
        return result;
    }
}
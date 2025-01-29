class Solution {
    public List<List<String>> solveNQueens(int n) {
        //Coulmn-wise placement of Queens...
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i ++) 
            for(int j = 0; j < n; j ++)
                board[i][j] = '.';
        List<List<String>> list = new ArrayList<>();
        DFS(0, board, n, list);
        return list;
    }

    void DFS(int col, char[][] board, int n, List<List<String>> list) {
        if(col == n) {
            list.add(constructList(board));
            return;
        }

        for(int row = 0; row < n; row ++) {
            if(placeQueens(row, col, board, n)) {
                board[row][col] = 'Q';
                DFS(col + 1, board, n, list);
                board[row][col] = '.';
            }
        }
    }

    boolean placeQueens(int row, int col, char[][] board, int n) {
        //only chk in left coz we' re placing column-wise
        for(int i = 0; i < n; i++) //chk left [same row]
            if(board[row][i] == 'Q') return false;
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) //chk upper diagonal left
            if(board[i][j] == 'Q') return false;
        for(int i = row, j = col; i < n && j >= 0; i++, j--) //chk lower diagonal left
            if(board[i][j] == 'Q') return false;
        return true;
    }

    List<String> constructList(char[][] board) {
        List<String> a = new ArrayList<>();
        for(int i = 0; i < board.length; i ++) {
            a.add(new String(board[i]));
        }
        return a;
    }
}
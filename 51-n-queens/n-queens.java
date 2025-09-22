class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        backtrack(0, n, board, res, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }
    
    private void backtrack(int row, int n, char[][] board, List<List<String>> res,
                           Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            // Convert board to list of strings
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            res.add(solution);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue; // not safe
            }
            
            // Place queen
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);
            
            // Recurse
            backtrack(row + 1, n, board, res, cols, diag1, diag2);
            
            // Backtrack (remove queen)
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}

51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]

  
Solution
//Using Back Tracking
class Solution {
    //Tc: O(n!) Sc: O(n^2)
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n == 0) return res;
        boolean[][] board = new boolean[n][n];
        backtrack(board, 0,n);
        return res;    
    }

    private void backtrack(boolean[][] board, int r, int n)
    {
        if(r == n){
            List<String> li = new ArrayList<>();
            for(int i = 0 ; i < n ;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j < n ; j++)
                {
                    if(board[i][j]) sb.append("Q");
                    else sb.append(".");
                }
                li.add(sb.toString());
            }
            res.add(li);
            return;
        }
        for(int j = 0 ; j < n; j++)
        {
            if(isSafe(board, r, j,n))
            {
                board[r][j] = true;
                backtrack(board, r+1,n);
                board[r][j] = false;

            }
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c, int n)
    {
        //up col
        for(int i = 0 ; i < r; i++)
        {
            if(board[i][c]) return false;
        }
        //diagonal up left
        int i = r;
        int j = c;
        while(i >= 0 && j >= 0)
        {
            if(board[i][j]) return false;
            i--;
            j--;
        }

        //diagonal up right
        i = r;
        j = c;
        while(i >= 0 && j < n)
        {
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}

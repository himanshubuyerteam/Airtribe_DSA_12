import java.util.*;

// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution 
{
    public static void helper(int sr,int sc,int [][]mat,ArrayList<String>ans,String tans,int [][]dir,String []s)
    {
        int dr=mat.length;
        int dc=mat[0].length;
        if(sr==dr-1 && sc==dc-1)
        {
            ans.add(tans);
            return;
        }
        mat[sr][sc]=0;
        for(int i=0;i<dir.length;i++)
        {
            int nr=sr+dir[i][0];
            int nc=sc+dir[i][1];
            if(nr>=0 && nr<dr && nc>=0 && nc<dc && mat[nr][nc]==1)
                helper(nr, nc, mat, ans, tans+s[i], dir, s);
        }
        mat[sr][sc]=1;
    }
    public static ArrayList<String> findPath(int[][] m, int n) 
    {
        int [][]dir={{1,0},{0,-1},{0,1},{-1,0}};
        String []s={"D","L","R","U"};
        String tans="";
        ArrayList<String>res=new ArrayList<>();
        boolean [][]vis=new boolean [n][n];
        if(m[0][0]==0 || m[n-1][n-1]==0)
            return res;
        helper(0,0,m,res,tans,dir,s);
        return res;        
    }
}




class Solution {
    // Helper function to check if placing a queen at position (row,col) is safe
    private boolean isSafePlace(int n, char[][] nQueens, int row, int col) {
        // Check if there's any queen in the same column above current position
        for (int i = 0; i < n; i++) {
            if (nQueens[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal for any queen
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal for any queen
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        // If no conflicts found, position is safe
        return true;
    }

    // Recursive helper function to solve N-Queens problem
    private void solveNQueens(int n, List<List<String>> output, char[][] nQueens, int row) {
        // Base case: if we've placed queens in all rows, we found a valid solution
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] rowArray : nQueens) {
                solution.add(new String(rowArray));
            }
            output.add(solution);
            return;
        }
        // Try placing queen in each column of current row
        for (int col = 0; col < n; col++) {
            // If current position is safe
            if (isSafePlace(n, nQueens, row, col)) {
                // Place queen
                nQueens[row][col] = 'Q';
                // Recursively solve for next row
                solveNQueens(n, output, nQueens, row + 1);
                // Backtrack: remove queen for trying next position
                nQueens[row][col] = '.';
            }
        }
    }
    // Main function to solve N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();  // Stores all valid solutions
        char[][] nQueens = new char[n][n];  // Initialize empty board
        
        // Fill the board with dots
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        
        solveNQueens(n, output, nQueens, 0); // Start solving from row 0
        return output;
    }
}
// Unique Paths

// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

// How many possible unique paths are there?

// Note: m and n will be at most 100.

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] DP = new int[m][n];
        
        for(int i=0; i<m; i++)
            DP[i][0] = 1;
        for(int i=0; i<n; i++)
            DP[0][i] = 1;
        
        for(int i = 1; i< m; i++){
            for(int j = 1; j< n; j++){
               DP[i][j] = DP[i-1][j] + DP[i][j-1]; 
            }
        }
        return DP[m-1][n-1];
    
        // Recursive solution as a build up to the above DP
//         if(m == 1 || n == 1)
//             return 1;
        
//         return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    
    }
}
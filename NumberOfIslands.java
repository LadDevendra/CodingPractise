// Number of Islands

// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// 11110
// 11010
// 11000
// 00000
// Answer: 1

// Example 2:

// 11000
// 11000
// 00100
// 00011
// Answer: 3

class Solution {
    public int numIslands(char[][] grid) {
    
//BackTracking time : O(m*n)        space : O(m*n)
        
        if(grid == null || grid.length == 0)
            return 0;
        //m*n
        int m = grid.length, n = grid[0].length, count = 0;
        //defaults to FALSE
        //boolean [][] visited = new boolean[m][n];
        
        //DFS solution
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                //Found new island
                if(grid[i][j] == '1'){
                    count++;
                    //traverse the whole island
                    DFS(i, j, m, n, grid);
                }
            }
        }
        return count;
    }
        
    public void DFS(int i, int j, int m, int n, char[][] grid){
        if(i<0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') 
            return;
        grid[i][j] = '0';
        DFS(i+1, j, m, n, grid);
        DFS(i-1, j, m, n, grid);
        DFS(i, j+1, m, n, grid);
        DFS(i, j-1, m, n, grid);
    }
}
// Set Matrix Zeroes
// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// click to show follow up.

// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

//could be furthre optimized 

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;
        
        //n * m matrix
        int n = matrix.length;
        int m = matrix[0].length;
        boolean rowFlag = false, columnFlag = false;
        
        for(int i =0; i< n; i++){
            for(int j=0; j< m; j++){
                if(matrix[i][j] == 0){
                    if(i == 0)
                        rowFlag = true;
                    if(j == 0)
                        columnFlag = true;
                    
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i< n; i++){
            for(int j =1; j<m; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(rowFlag)
            for(int j=0; j<m; j++)
                matrix[0][j] = 0;
        
        if(columnFlag)
            for(int i =0; i<n; i++)
                matrix[i][0] = 0;
        
    }
}
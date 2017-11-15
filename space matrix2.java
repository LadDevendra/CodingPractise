// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// For example,
// Given n = 3,

// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]


class Solution {
    public int[][] generateMatrix(int n) {
        n = Math.abs(n);
        int k = 1;
        int[][] matrix = new int[n][n];
        int top = 0, left = 0, right = n-1, bottom = n-1;
        
        while(k<=n*n){
            
            for(int i=left; i<= right; i++)
                matrix[top][i] = k++;
            top++;
            
            for(int i=top; i<= bottom; i++)
                matrix[i][right] = k++;
            right--;
            
            for(int i=right; i>= left; i--)
                matrix[bottom][i] = k++;
            bottom--;
            
            for(int i=bottom; i>= top; i--)
                matrix[i][left] = k++;
            left++;
        }
        return matrix;
    }
}
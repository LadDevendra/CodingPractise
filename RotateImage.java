// Rotate Image
// Given input matrix = 
// [
//   [1,2,3],
//   [4,5,6],
//   [7,8,9]
// ],

// rotate the input matrix in-place such that it becomes:
// [
//   [7,4,1],
//   [8,5,2],
//   [9,6,3]
// ]


class Solution {
    public void rotate(int[][] matrix) {
        //General -> flip upside down and then diagonally
        //rotate only upper half rows
        if(matrix == null || matrix.length == 0)
            return;
        int len = matrix.length;
        
        for(int i = 0; i< len/2; i++){
            for(int j=0; j< len; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-i-1][j];
                matrix[len-i-1][j] = temp;
            }
        }
        //iterate only left bottom triangle of matrix
        for(int i = 1; i< len; i++){
            for(int j=0; j< i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
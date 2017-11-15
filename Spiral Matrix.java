// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5]

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<Integer>();
        
        if(matrix == null || matrix.length == 0)
            return results;
        
        int m = matrix.length; //rows
        int n = matrix[0].length; //columns
        int x = 0, y = 0; //ptrs
        
        while(m > 0 && n > 0){
            
            //special cases.. one row or one column remaining..
            if(m == 1){
                for(int i = 0; i< n; i++)
                    results.add(matrix[x][y++]);
                break;
            }else if(n == 1){
                for(int i = 0; i< m; i++)
                    results.add(matrix[x++][y]);
                break;
            }
            
            //make circle
            //left to right
            for(int i=0; i< n-1; i++)
                results.add(matrix[x][y++]);
            //top to bottom
            for(int i=0; i< m-1; i++)
                results.add(matrix[x++][y]);
            //right to left
            for(int i=0; i< n-1; i++)
                results.add(matrix[x][y--]);
            //bottom to top
            for(int i=0; i< m-1; i++)
                results.add(matrix[x--][y]);
            //inner circle
            x++;
            y++;
            //size reduces by 2 because of circular wall
            m-=2;
            n-=2;
        }
        return results;
    }
}
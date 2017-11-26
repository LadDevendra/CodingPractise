// Minimum Number of Arrows to Burst Balloons

// Input:
// [[10,16], [2,8], [1,6], [7,12]]

// Output:
// 2

// Explanation:
// One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0)
            return 0;
        int arrows = 1;
        //sort according to end time.
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int end = points[0][1];
        for(int i = 1; i< points.length; i++){
            if(points[i][0] > end){
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }
}
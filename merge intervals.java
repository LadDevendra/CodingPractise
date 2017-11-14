// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null | intervals.size() < 2 )
            return intervals;  
        
        //sort intervals by start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        //set first start and end time
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> result = new ArrayList<>();
        
        for(Interval interval : intervals){
            //extend the end time if required
            if(interval.start <= end){
                end = Math.max(interval.end, end);
            }
            else{
                //add the interval to the result and reset start end
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        //add the last interval
        result.add(new Interval(start, end));
        return result;
    }
}

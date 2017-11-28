//Decode Ways

// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.


class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length() == 0) return 0;
        int len = s.length();
        //DP solution
        int DP[] = new int[len+1];
        DP[0] = 1;
        //solution until 0th character.
        DP[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i =2; i<= len; i++){
            //if last digit isnt zero, add it
            if(s.charAt(i-1) != '0')
                DP[i] += DP[i-1];
            //if last two digits make a valid number in (10 - 26), not first 10 coz that will be same as consifering just last digit
            if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6'))
                DP[i] += DP[i-2];
        }
        //solution till len-1 in input string
        return DP[len];
    }
}
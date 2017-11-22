//atoi

// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.


class Solution {
    public int myAtoi(String str) {
        if(str == null || str.isEmpty())
            return 0;
        //remove whitespaces;
        str = str.trim();
        boolean negativeFlag = false;
        int i = 0;
        
        if(str.charAt(i) == '+')
            i++;
        else if(str.charAt(i) == '-'){
            negativeFlag = true;
            i++;
        }
        //store the result in double to avoid overflow.
        double result = 0;
        
        while(i<str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0' ){
            result = result * 10 + str.charAt(i) - '0';
            i++;
        }
        if(negativeFlag)
            result = -result;
        
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        
        return (int)result;
    }
}
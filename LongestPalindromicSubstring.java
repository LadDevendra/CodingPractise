//Longest Palindromic Substring

// Input: "babad"

// Output: "bab"

// Note: "aba" is also a valid answer.
// Example:

// Input: "cbbd"

// Output: "bb"

class Solution {
    int start = 0, maxlen = 0;
    public String longestPalindrome(String s) {
        if(s == null)
            return null;
        
        int len = s.length();
        if(len < 2)
            return s;
        for(int i=0; i<len-1; i++){
            //odd Substrings and then even substrings..
            checkLongestSubString(i, i, s);
            checkLongestSubString(i, i+1, s);
        }
        return s.substring(start, start+maxlen);             
    }
    public void checkLongestSubString(int l, int r, String s){
        while(l>= 0 && r< s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if(r-l-1 > maxlen){
            maxlen = r-l-1;
            start = l+1;
        }
    }
}
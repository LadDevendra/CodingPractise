
// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Could you do it in-place without allocating extra space?

class Solution {
    public void reverseWords(char[] str) {
        int len = str.length;
        int i = 0;
        for(int j=0; j< len; j++){
            if(str[j] == ' '){
                reverse(str, i, j-1);
                i = j+1;
            }
        }
        reverse(str, i, len-1);
        reverse(str, 0, len-1);
    }
    
    public void reverse(char[] str, int i, int j){
        while(i<j){
            char temp = str[j];
            str[j] = str[i];
            str[i] = temp;
            i++;
            j--;
        }
    }
}
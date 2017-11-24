// Simplify Path

// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"

class Solution {
    public String simplifyPath(String path) {
     if(path == null)
         return null;
    Stack<String> stack = new Stack<>(); 
     Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        
    for(String s: path.split("/")){
        if(s.equals("..")){
            if(!stack.isEmpty())
                stack.pop();
        }
        else if(!skip.contains(s))
            stack.push(s);
    }
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()) 
        sb.insert(0, "/" + stack.pop());
    return sb.toString().equals("") ? "/" : sb.toString();
    }
}
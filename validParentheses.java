/*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

/* use stack */

public class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()==0 || s.length()%2==1)
            return false;
        char chout=' ';   
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
        
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);   
            }
           
            if(ch==')' || ch=='}' || ch==']'){
                if(st.size()<=0){
                    return false;
                }
                chout=st.pop();
            
                if((ch==')' && chout=='(' ) || (ch=='}' && chout=='{') || (ch==']' && chout=='[')){
                    continue;
                }else{
                    return false;
                }
            }
        }
        
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}
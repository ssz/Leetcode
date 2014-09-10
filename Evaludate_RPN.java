/*  Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, /. Each operand may be an integer or another expression.
    
    Use stack
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        
        if(tokens==null || tokens.length==0){
            return 0;
        }
        
        Stack<Integer> st = new Stack<Integer>(); 
        
        int N=tokens.length;
        for(int i=0; i<N; i++){
        	String ch = tokens[i];
           if(!isOperator(ch)){
               st.push(Integer.parseInt(ch)); 
            }else{
                int ch1 = Integer.valueOf(st.pop()); //later one
                int ch2=Integer.valueOf(st.pop()); // former one
                if(ch.equals("+")){
                	st.push(ch1+ch2);
                }else if(ch.equals("-")){
                	st.push(ch2-ch1);
                }else if(ch.equals("*")){
                	st.push(ch1*ch2);
                }else{
                	st.push(ch2/ch1);
                }
            }    
        }
        return Integer.valueOf(st.pop());  
    }
    
    private boolean isOperator(String ch){
        if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/"))
            return true;
		return false;
	}
}
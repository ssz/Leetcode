/*

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).

*/

/* Solition 1: */

public class Solution {
    public int reverse(int x) {
        int result = 0;
        int flag = 0;
        if(x<0) flag=-1;
        x = Math.abs(x);
        while(x > 0){
            result = result*10 + x%10;
            x=x/10;
        }
        
        if(result < 0){
            return -1;
        }
        
        if(flag == -1){
            return result*= -1; 
        }
        
        return result;
    }
}

/* The following two solutions comes from Github: Walnutown.*/
/* From JDK1.0, Integer has MIN_VALUE and MAX-VALUE
   public static final int   MIN_VALUE = 0x80000000;
   public static final int   MAX_VALUE = 0x7fffffff;
*/

// cast int to long to avoid overflow
public class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        long res = 0;
        while (num > 0){
            res = res*10 + num%10;
            num /= 10;
        }
        if (res>Integer.MAX_VALUE)   return x>0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return x>0 ? (int)res : (int)-res;          // need cast here, otherwise, precision loss warning
    }
}



public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x!=0){
            int digit = x%10;
            if (digit>Integer.MAX_VALUE%10 && res==Integer.MAX_VALUE/10 || res>Integer.MAX_VALUE/10)
                return Integer.MAX_VALUE;
            if (digit < Integer.MIN_VALUE%10 && res==Integer.MIN_VALUE/10 || res<Integer.MIN_VALUE/10)
                return Integer.MIN_VALUE;
            res = res*10 + digit;
            x /= 10;
        }
        return res;
    }
}


/* 
	From this question, think about string reverse. The followings are some solution about string reverse.
	Thanks to http://www.importnew.com/501.html
*/
/* Solution 1: StringBuffer */
public class JdkReverser implements Reverser { 
    public String reverse(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
           }
        return new StringBuffer(str).reverse().toString();
    }
}

/* Solution 2: Recursion */ 
public String reverse(String str) {
    if ((null == str) || (str.length()  <= 1)) {
        return str;
    }
    return reverse(str.substring(1)) + str.charAt(0);
}

/* Solution 3: */
public String reverse(String str) {
    if ((null == str) || (str.length()  <= 1 )) {
    	return str;
    }
    StringBuffer result = new StringBuffer(str);
    for (int i = 0; i < (str.length() / 2); i++) {
        int swapIndex = str.length() - 1 - i;
            char swap = result.charAt(swapIndex);
            result.setCharAt(swapIndex, result.charAt(i));
            result.setCharAt(i, swap);
    }
    return result.toString();
}


/* There is also a question about "Reverse Words in a String" on Leetcode.*/


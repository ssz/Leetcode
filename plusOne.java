/*
    Given a non-negative number represented as an array of digits, plus one to the number.
    The digits are stored such that the most significant digit is at the head of the list.
*/

import java.util.Arrays;

public class solution {
    public static void main(String[] args){
        int[] digits ={8,9,9};
        int[] intArray = plusOne(digits);
        String intArrayString = Arrays.toString(intArray); 
        //System.out.println(a);
        System.out.println(intArrayString);
        
    }
    
    public static int[] plusOne(int[] digits) {
        if (digits==null || digits.length==0) return digits;
        int l=digits.length;
        //System.out.println(l);
        int flag=0;
        ++digits[l-1];
        for(int j = l-1; j >= 0; j--){
            digits[j] = digits[j] + flag;
            if (digits[j] == 10) {
                flag = 1;
                digits[j] = 0;
            }
            else break;
        }
        
        if(digits[0]==0 && flag==1){ 
             int[] res = new int[digits.length+1];
             res[0] =1;
             return res;
       }else{
             return digits;

       } 
    }
}


// Solution comes from Hu Tao.
// Maintain a varialble to hold the carry
// Traverse from the least significant digit to the most significant digit
// Finally, we have to check 'carry' to know whether we have to resize the array
// One interesting thing is that if we have to resize the array, actually we don't have
// to copy vlaues from original array to new array, because all the values are zero
// time: O(n); space: O(n)
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits==null || digits.length==0)   return digits;
        int carry =1;
        for (int i=digits.length-1; i>=0; i--){
            int val = digits[i];
            digits[i] = (carry+val)%10;
            carry = (carry+val)/10;
        }
        if (carry==0)   return digits;
        // if we're here, the digits should be 9999..9, and the res is 10000..0
        int[] res = new int[digits.length+1];
        res[0] =1;
        return res;
    }
}

// Wrong solution: Read all numbers from the array and combine it as a number.
// Then add 1 and store every digit into the array.
// But temp's type is int! Although it can use Long, array can get lager.
// When the digits array becomes very large, 
// then the last digits cannot match correctly.
public class solution {
	public static void main(String[] args){
		int[] digits ={6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
		int[] intArray = plusOne(digits);
		String intArrayString = Arrays.toString(intArray); 
		//System.out.println(a);
		System.out.println(intArrayString);
		
	}
	
    public static int[] plusOne(int[] digits) {
        if (digits==null || digits.length==0) return digits;
        int l=digits.length; double temp=0;
        //System.out.println(l);
        for(int j=0; j<l; j++){
        	int m=l-1-j;
        	//System.out.println(Math.pow(10, 0));
            temp+=digits[j]*Math.pow(10,m);
            System.out.println("aa"+temp);
        }
        temp+=1; int result=0, i=0;
        for(; i<l; i++){
            result=(int) (temp%10);
            temp=temp/10;
            System.out.println(temp);
            digits[l-1-i]=result;
        }
   
        if(temp<1){ 
        	System.out.println("Hello");
            return digits;
        }else{
            int[] res = new int[digits.length+1];
            res[0] =1;
            return res;
        } 
    }
}
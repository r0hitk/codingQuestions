

public class LongestPalindrome {

	
	//Longest palindrome using bruteforce.
	public static void main(String[] args) {

		String str = "darkknightthginkdark"; 
	    
		System.out.println("Max length of the palindrome is: " + longestPalindrome(str));
		
	}
	
	
	
	// This function prints the longest palindrome substring. It also returns the length 
	// of the longest palindrome.
	
	public static int longestPalindrome(String str) 
	{ 
	    // get length of input string 
	    char strArray[] = str.toCharArray();
	  
	    // All substrings of length 1 are palindromes 
	    int maxLength = 1, start = 0; 
	  
	    // Nested loop to mark start and end index 
	    for (int i = 0; i < strArray.length; i++) { 
	        for (int j = i; j < strArray.length; j++) { 
	            int flag = 1; 
	  
	            // Check palindrome 
	            for (int k = 0; k < (j - i + 1) / 2; k++) 
	                if (strArray[i + k] != strArray[j - k]) 
	                    flag = 0; 
	  
	            // Palindrome 
	            if ((flag == 1) && ((j - i + 1) > maxLength)) { 
	                start = i; 
	                maxLength = j - i + 1; 
	            } 
	        } 
	    } 
	  
	    System.out.print("Longest palindrome substring is: ");
	    printOutput(strArray, start, start + maxLength - 1); 
	  
	    // return length of Longest palindrome 
	    return maxLength; 
	} 
	
	
	public static void printOutput(char[] str, int low, int high) 
	{ 
	    for (int i = low; i <= high; i++) 
	       System.out.print(str[i]);
	    
	    System.out.println();
	} 

}

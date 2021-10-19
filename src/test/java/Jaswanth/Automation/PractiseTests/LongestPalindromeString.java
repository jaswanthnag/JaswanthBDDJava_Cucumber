package Jaswanth.Automation.PractiseTests;

public class LongestPalindromeString 
{
	
	/*
	 * The solution given here works on the logic that in a palindrome, starting
	 * from the center, if two cursors are moved left and right respectively one
	 * character at a time, those values should be equal. This holds true if the
	 * length of the string is odd.
	 * 
	 * As example if string is 121 then centre is 2. Character at the left and
	 * character at the right, if checked for equality should be equal. You can
	 * check for 24642, aba, malayalam.
	 * 
	 * If the length of the string is even then you have to take 2 characters as
	 * center, and then check the character at the left and character at the right
	 * for equality. Of course two characters considered as center should be equal
	 * too.
	 * 
	 * As example if string is 1221, then centre is 22 from there you move one
	 * character to left and one character to right. You can check for toppot, abba.
	 */
	
	
	public static void main(String[] args) {
		LongestPalindromeString pd = new LongestPalindromeString();
	    
	    String pal = pd.findLongestPalindrome("bananas");
	    System.out.println("" + pal);
	    
	    pal = pd.findLongestPalindrome("abaradar121");
	    System.out.println("" + pal);
	  }
	    
	  public String findLongestPalindrome(String s) {
	    // Validations
	    if (s.isEmpty()) {
	      return "Please enter a String";
	    }

	    if (s.length() == 1) {
	      return s;
	    }
	    // Validations end
	    // Start with one char (starting) as a longest palindrome
	    String longest = s.substring(0, 1);
	    
	    
	    for (int i = 0; i < s.length(); i = i+1) {        
	      // get longest palindrome for odd length (center is i)
	      String tmp = checkForEquality(s, i, i);
	      if (tmp.length() > longest.length()) {
	        longest = tmp;
	      }

	      // get longest palindrome for even length (center is i, i+1)
	      tmp = checkForEquality(s, i, i + 1);
	      if (tmp.length() > longest.length()) {
	        longest = tmp;
	      }
	    }
	    return longest;
	  }
	    
	    
	  /**
	  * In this method equality is checked starting from
	  * the center moving one character left and one character
	  * right from the center. If both chars are equal then the
	  * next set of chars are checked.  
	  *     
	  */
	  public String checkForEquality(String s, int begin, int end) {
	    while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
	      begin--;
	      end++;
	    }
	    return s.substring(begin + 1, end);    
	  }

}

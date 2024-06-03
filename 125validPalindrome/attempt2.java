class Solution {
    public boolean isPalindrome(String s) {
      String cleanedString = "";
      for (int i = 0; i < s.length(); i++)
      {
        if (Character.isLetterOrDigit(s.charAt(i)))
        {
            cleanedString += Character.toLowerCase(s.charAt(i));
        }
      }

      int k = cleanedString.length()-1;
      for (int i =0; i < cleanedString.length(); i++)
      {
        if (cleanedString.charAt(i) != cleanedString.charAt(k))
        {
            return false;
        }
        k--;
      }
      return true;
    }
}
import java.lang.*;
import java.io.*;
import java.util.*;

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
        
        StringBuilder reverse = new StringBuilder();
        reverse.append(cleanedString);
        reverse.reverse();
        System.out.println(cleanedString);
        System.out.println(reverse);
        return cleanedString.equals(reverse.toString());
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        int k = s.length() -1;
        for (int i = 0; i < s.length(); i++)
        {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < s.length()-1)
            {
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(k)) && (k > 0))
            {
                k--;
            }
            System.out.println("Comparing " + s.charAt(i) + "and " + s.charAt(k));
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(k)))
            {
                return false;
            }
            if (k > 0)
            {
                k--;
            }
        }
        return true;
    }
}
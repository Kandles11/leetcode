import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int length = 0;
        for (Character a : s.toCharArray())
        {
            if (set.contains(a))
            {
                length += 2;
                set.remove(a);
            }
            else
            {
                set.add(a);
            }
        }
        if (set.size() > 0)
        {
            length+= 1;
        } 
        return length;
    }
}
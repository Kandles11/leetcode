import java.util.HashMap;
import java.util.Set;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> first = new HashMap<Character, Integer>();
        HashMap<Character, Integer> second = new HashMap<Character, Integer>();
        
        if (s.length() != t.length())
        {
            return false;
        }

        for(int i = 0; i < s.length(); i++)
        {
            if (first.get(s.charAt(i)) == null)
            {
                first.put(s.charAt(i), 1);
            }
            else
            {
                first.put(s.charAt(i), first.get(s.charAt(i)) + 1);
            }
        }

        for(int i = 0; i < t.length(); i++)
        {
            if (second.get(t.charAt(i)) == null)
            {
                second.put(t.charAt(i), 1);
            }
            else
            {
                second.put(t.charAt(i), second.get(t.charAt(i)) + 1);
            }
        }

        Set<Character> elements = first.keySet();

        for(Character element : elements)
        {
            if (!first.get(element).equals(second.get(element)))
            {
                return false;
            }
        }
        return true;
    }
}
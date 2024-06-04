import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {

        if (s.length() == 1)
        {
            return 1;
        }

        char[] values = s.toCharArray();
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();

        for (int i =0; i < values.length; i++)
        {
            counts.put(values[i], counts.getOrDefault(values[i], 0)+1);
        }

        int sum =1;
        for (int count : counts.values())
        {
            sum += (count/2)*2;
        }
        if (sum > s.length())
        {
            sum--;
        }
        return sum;
    }
}
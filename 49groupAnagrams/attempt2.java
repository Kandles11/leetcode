import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> anagrams = new HashMap<String, List<String>>();
        for (String word: strs)
        {
            char[] wordArray = word.toCharArray();
            int[] counts = new int[26];
            for (Character c: wordArray)
            {
                int charIndex = c;
                counts[charIndex-97]++;
            }
            String countString = new String(Arrays.toString(counts));
            if (anagrams.get(countString) == null)
            {
                List<String> strings = new ArrayList<String>();
                strings.add(word);
                anagrams.put(countString, strings);
            }
            else
            {
                anagrams.get(countString).add(word);
            }
        } 
        List<List<String>> solution = new ArrayList<List<String>>(anagrams.values());
        return solution;        
    }
}
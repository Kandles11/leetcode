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
            Arrays.sort(wordArray);
            String sortedString = new String().valueOf(wordArray);
            if (anagrams.get(sortedString) == null)
            {
                List<String> strings = new ArrayList<String>();
                strings.add(word);
                anagrams.put(sortedString, strings);
            }
            else
            {
                anagrams.get(sortedString).add(word);
            }
        }
        List<List<String>> solution = new ArrayList<List<String>>(anagrams.values());
        return solution;        
    }
}
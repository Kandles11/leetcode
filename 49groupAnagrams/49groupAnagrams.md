# 49: Group Anagrams
`Sun, May 12th, 2024 8:12:52PM`

This is the first "medium" difficulty problem I've come across, which makes me want to think it through first before just jumping into code.

49: Group Anagram
```
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
```

## Counting.
My first idea had to do with using a similar approach as 242: Valid Anagrams, but since that requires we iterate through each character, we already of O(N^2) right there, which isn't ideal. 

## Sorting?
As of now, I'm leaning towards a solution that stores a hashmap with key of sorted strings with value of the list of original strings. We go through each entry, sort it, check that values in the map, and place it where it goes. On second thought, pretty sure that gives a time complexity of O(n*n log n). Much worse than O(n). After pondering, it seems the most ideal, so lets go ahead and implement it.

## Attempt 1:
```java
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<char[], List<String>> anagrams = new HashMap<char[], List<String>>();
        for (String word: strs)
        {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            if (anagrams.get(wordArray) == null)
            {
                List<String> strings = new ArrayList<String>();
                strings.add(word);
                anagrams.put(wordArray, strings);
            }
            else
            {
                anagrams.get(wordArray).add(word);
            }
        }
        List<List<String>> solution = new ArrayList<List<String>>(anagrams.values());
        return solution;        
    }
}
```

After running for the first time, I just back a list of all the strings. Not ideal...
Turns out the issue was using character arrays. Duh, those can't compare equally. Turning those back into Strings and adjusting the hashmap fixed it!
With that, here's the new code:

```java
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
```

## Attempt 2:
After going back and watching the NeetCode video, I found that my solution, while clever, is not the most effecient, just as I predicted. Because of this, I'll try and implement it as I originally theorized, by counting all the characters in the String.

```java
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
```
This solution was a lot more annoying to implement, and I'm way happier with my previous solution. This solution was much slower in practice on Leetcode, and is much less elegant. While theroritcally it should be faster, in practice, it isn't. One reason for this is the length of the strings. With strings never exceeding 100 characters, the first solution will always be faster.
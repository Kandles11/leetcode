# 2486. Append Characters to String to Make Subsequence
`Mon, June 3rd, 2024 3:45:05 PM`

I decided rather than follow the Neetcode path, that I would do the daily problem to test out my skills (i also love little streaks).
Here's the problem:
```
You are given two strings s and t consisting of only lowercase English letters.

Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
```

Let's try it out:

## Attempt 1:
My initial thinking is that we take t, check if the first character is present in the string. If it is, we move on to the first and 2nd char. Keep going until we find a substring that isn't in the string. Wherever we leave off, we know to just add the remaining string.

Here's where I ended up:
```java
class Solution {
    public int appendCharacters(String s, String t) {
        int i =0;
        //should find the max substring that's in S
        for(i =0; i <= t.length(); i++)
        {
            if (t.length() == 1)
            {
                if(!s.contains(t))
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
            else if(!s.contains(t.substring(0, i)))
            {
                i--;
                break;
            }
        }
        System.out.println("i is " + i);
        System.out.println("largest string is " + t.substring(0,i));
        return t.length() -i;
    }
}
```

The flaw with this solution is that it only works if the substring is continuous in S. We don't account for the cases where it might be split

## Attempt 2:
My thinking for attempt 2 is that what if instead of using the substring feature for a chunk, we check if each letter exists sequentially, but make sure it occurs after the first one index wise.

In the example:
```
s = "vrykt"
t = "rkge"
```
we check if 'r' exists in the string, keep track of the index of it. Then we check 'k' and check if it exists after 'r'. My main concern is runtime. I'm expecting somewhere around O(n log n) for this solution.

This was the solution that I came up with, which seemed alot simpler and made alot more intuitive sense in my mind:

```java
class Solution {
    public int appendCharacters(String s, String t) {
        int i =0;
        int k =0;
        for (i = 0; i < t.length(); i++)
        {  
            k = s.indexOf(t.charAt(i), k);
            if (k == -1)
            {
                return t.length() - i;
            }
        }
        return 0;
    }
}
```

This worked for most test cases, but not all. I still haven't figured out why it fails around 90,000 characters. I decided to read the leetcode solution to see how to approach this, which is done below.

## Attempt 3:
I'm dissapointed that I had to check the solution on this one since it seemed so simple and I was so close, but I was not using the correct approach for this problem.

This ended up being my final solution:
```java
class Solution {
    public int appendCharacters(String s, String t) {
        int k =0;
        for (int i = 0; i < s.length(); i++)
        {  
           if (s.charAt(i) == t.charAt(k))
           {
            if(k == t.length()-1)
            {
                k++;
                break;
            }
            k++;
           }
        }
        return t.length() - k;
    }
}
```

This solution feels very clean, and was faster than majority of Java responses. I feel like if I would've thought a little harder, I could've firgured this one out.
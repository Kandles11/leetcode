# 409. Longest Palindrome
`Tues, June 4th, 2024 8:01:05 AM`

The problem of the day on leetcode today was longest palidrome, which on first glance, looks super simple. Let's work it out!

```
Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.
```

## Attempt 1
My intuition says we just need to count all the characters, divide by 2 and floor it. After that, sum the values.

Here's the first solution I came up with:
```java
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
```
I'm not really a fan of how many special cases I had to implement, and would prefer a cleaner algorithm. Also, my speed is not optimal.

![alt text](image.png)

## Attempt 2
After reading the solution on leetcode, I now realize a faster way to do it. Let's use a hashset to keep track of what we've seen. If we see a repeat character, remove it and add 2 to our length. Should be pretty simple to implement.

```java
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
```

Wow, this one is def a lot cleaner, and I'm really happy with how this one turned out. Wish I could've come up with it originally, but overall I think this problem went pretty well!

![alt text](image-1.png)
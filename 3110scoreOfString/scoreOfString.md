# 3110. Score of a String
`Tues June 4th, 2024 10:29:53AM`

For this problem, I bought my first time-travel ticket so I could go back and try and complete the entire month of June challenge on LeetCode. Here is day one of June, a super easy problem.

```
You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.

Return the score of s.
```

## Attempt 1:
My line of thought is saying we just need a for loop, store the last int, add to the current int, and add it to the sum, and move forward.

```java
class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        int lastNum = s.charAt(0);
        for (int i = 1; i < s.length(); i++)
        {
            sum += Math.abs(lastNum - s.charAt(i));
            lastNum = s.charAt(i);
        }
        return sum;
    }
}
```

And that's it, we're already done!
Super easy make-up problem.

![alt text](image.png)
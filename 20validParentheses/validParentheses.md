# 240. Valid Parentheses
`Tues, June 4th 2024 9:15AM`

```
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
```

This one seems like a simple problem to tackle with a stack. Pretty sure we did this exact example in our DSA class.

## Attempt 1:
That seemed really simple, and after fixing some tiny bugs, this is where we ended up:

```java
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character a : s.toCharArray()) {
            // open bracket
            if (a == '{' | a == '(' || a == '[') {
                stack.addFirst(a);
            } else // closed
            {
                Character removed;
                try {
                    removed = stack.removeFirst();
                } catch (Exception e) {
                    return false;
                }
                switch (a) {
                    case '}':
                        if (removed != '{'){
                            return false;
                        }
                        break;
                    case ')':
                        if (removed != '(')
                        {
                            return false;
                        }
                        break;
                    case ']':
                        if (removed != '[')
                        {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        if (stack.size() > 0)
        {
            return false;
        }
        return true;
    }
}
```

I don't love the amount of "cases", but I feel like that was necessary to solve this problem. My solution wasfast, but on the slower end of the spectrum compared to others, so let's check out the real solution.

![alt text](image.png)


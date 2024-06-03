# 125 Valid Palindrome
`Mon, June 3rd, 2024 1:25:52PM`
Today is the first day I've worked on Leetcode in over 3 weeks, and today I decided to work on it during some downtime at work! I went ahead and decided to move forward from hashmap problems and go ahead and move forward for now, with the plan to be to return back once I get more practice.

```
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
```

## Attempt 1:
My first instinct is to just compare the first and last character, see if they are equal, and keep going until we reach the middle. If it's in invalid character, we just skip over it. Should be pretty easy!

My first major attempt has some obvious flaws,  the main one being that it will sometimes jump two places to try and skip character. Let me try again but instead use while loops.
```java
class Solution {
    public boolean isPalindrome(String s) {
        int k = s.length() -1;
        for (int i = 0; i < s.length(); i++)
        {
            if (!Character.isLetterOrDigit(s.charAt(i)))
            {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(k)))
            {
                k--;
                continue;
            }
            System.out.println("Comparing " + s.charAt(i) + "and " + s.charAt(k));
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(k)))
            {
                return false;
            }
            k--;
        }
        return true;
    }
}
```
After toying around with this method, I think I'm going to go ahead and try again with a new approach, as this one is getting more and more complicated.

```java
class Solution {
    public boolean isPalindrome(String s) {
        int k = s.length() -1;
        for (int i = 0; i < s.length(); i++)
        {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < s.length()-1)
            {
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(k)) && (k > 0))
            {
                k--;
            }
            System.out.println("Comparing " + s.charAt(i) + "and " + s.charAt(k));
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(k)))
            {
                return false;
            }
            if (k > 0)
            {
                k--;
            }
        }
        return true;
    }
}
```

# Attempt 2
This attempt is going to just go through the entire string, clean it up, then do the process. Should be O(2n)

It works! Here's the code for the solution:
```java
class Solution {
    public boolean isPalindrome(String s) {
      String cleanedString = "";
      for (int i = 0; i < s.length(); i++)
      {
        if (Character.isLetterOrDigit(s.charAt(i)))
        {
            cleanedString += Character.toLowerCase(s.charAt(i));
        }
      }

      int k = cleanedString.length()-1;
      for (int i =0; i < cleanedString.length(); i++)
      {
        if (cleanedString.charAt(i) != cleanedString.charAt(k))
        {
            return false;
        }
        k--;
      }
      return true;
    }
}
```

Let's check out the results...
![Leetcode Results](image.png)
oh. That's disappointing. Let's try it again with some optimizations in mind.

## Attempt 3:
One thing we don't have to worry about is checking every single entry. We should only have to check half the array. 

```java
class Solution {
    public boolean isPalindrome(String s) {
        int i =0;
        int j =s.length()-1;
      while (i <= j)
      {
        if (!Character.isLetterOrDigit(s.charAt(i)) && i < s.length()-1)
        {
            i++;
            continue;
        }
        if (!Character.isLetterOrDigit(s.charAt(j)) && j > 0)
        {
            j--;
            continue;
        }
        System.out.println("comparing" + s.charAt(i) + s.charAt(j));
        if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
        {
            return false;
        }
        i++;
        j--;
      }
      return true;
    }
}
```

Ok, well there is a difference, but not much. 
![Leetcode 2](image-1.png)

## Attempt 4
As a final attempt, I'm going to do the lazy approach.

```java
class Solution {
    public boolean isPalindrome(String s) {
        String cleanedString = "";
        for (int i = 0; i < s.length(); i++)
        {
          if (Character.isLetterOrDigit(s.charAt(i)))
          {
              cleanedString += Character.toLowerCase(s.charAt(i));
          }
        }
        
        StringBuilder reverse = new StringBuilder();
        reverse.append(cleanedString);
        reverse.reverse();
        System.out.println(cleanedString);
        System.out.println(reverse);
        return cleanedString.equals(reverse.toString());
    }
}
```

Great, the slowest solution yet...

![alt text](image-2.png)

## Attempt 5:
I'm not giving this one up until I can get a decent runtime. So far, attempt 3 has had the best runtime. Let's see if we can build on that one.

First potential speed-up is using a while loop to skip characters:

```java
class Solution {
    public boolean isPalindrome(String s) {
        int i =0;
        int j =s.length()-1;
      while (i <= j)
      {
        while (!Character.isLetterOrDigit(s.charAt(i)) && i < s.length()-1)
        {
            i++;
        }
        while (!Character.isLetterOrDigit(s.charAt(j)) && j > 0)
        {
            j--;
        }
        System.out.println("comparing" + s.charAt(i) + s.charAt(j));
        if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
        {
            return false;
        }
        i++;
        j--;
      }
      return true;
    }
}
```
aaand a testcase failed.
`".,"`
are you kidding me...

Ok fine, changing the removal case should fix it:
```java
class Solution {
    public boolean isPalindrome(String s) {
        int i =0;
        int j =s.length()-1;
      while (i <= j)
      {
        while (!Character.isLetterOrDigit(s.charAt(i)) && i < j)
        {
            i++;
        }
        while (!Character.isLetterOrDigit(s.charAt(j)) && j > i)
        {
            j--;
        }
        if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
        {
            return false;
        }
        i++;
        j--;
      }
      return true;
    }
}
```
And now let's test:
![alt text](image-3.png)

FINALLY! I think the true issue ended up being the println I left in the code. Let's check...

## Revisiting

### Attempt 3:
![alt text](image-4.png)

Just like I thought, removing the SOUT fixes it. The other solutions are just slow. Let's count this one done 👍




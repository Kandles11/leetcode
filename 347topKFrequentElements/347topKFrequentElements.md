# 347: Top K Frequent Elements
`Sun, May 12th, 2024 9:35:45PM`
Upon first investigation of this problem, it seems very simple to tackle. For that reason, I feel like after doing a small outline of my plan, I feel like jumping right in should give a good solution for this problem.

```
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
```

## Attempt 1:
The general idea behind this solution is that we can count each element and store the values in a hashmap. Once we have the the counts, output the max element and remove it. Repeat k times.

```java
import java.util.HashMap;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int value: nums)
        {
            if (counts.get(value) == null)
            {
                counts.put(value, 1);
            }
            else
            {
                counts.put(value, counts.get(value) + 1);
            }
        }
        for (int i =0; i < k; i++)
        {
            for (Integer value: counts.values())
            {
                //this is gonna be slowww
            }
        }
    }
}
```

At this point, I realized this time-complexity sucked, and i stopped here.This is essentially just iterating through the array k times, deleting the largest element. With the nested for loops, I knew there had to be a better way.

## Attempt 2
My next attempt is envisioning some sort of linked list structure. If I can keep track of the maximum, value, anytime its exceeded in count, we shift it to the front of the list. Once we go through the whole list, the top elements *should* be at the front?

As I'm writing this code, I'm realizing that this won't work for all situations. If we just move whenever a new max element is found, it doesn't always account for the kth largest.

Here is the code up until the point I stopped and thought harder:

```java
import java.util.HashMap;
import java.util.LinkedList;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        LinkedList<Integer> ranking = new LinkedList<Integer>();
        int maxCount = 0;
        int maxValue = 0;
        for (int value: nums)
        {
            if (counts.get(value) == null)
            {
                counts.put(value, 1);
                if (1 > maxCount)
                {
                    maxCount = 1;
                    maxValue = value;
                }
            }
            else
            {
                counts.put(value, counts.get(value) + 1);
                if (counts.get(value) > maxCount)
                {
                    maxCount = counts.get(value);
                    maxValue = value;
                }

            }
        }
        
    }
}
```

After sitting and thinking, the next best thing I could think of is some sort of tree structure, but I went ahead and watched the video for the solution.

## Attempt 3:
This solution is described as a modified bucket sort. We will have an array, same length as the nums array, and we will use each index as the count, and value as the list of elements with that count. We use an array instead of a hashmap to make counting k times easier.

This solution was NOT fun to implement, and felt like pulling teeth the entire way, but I eventually finished it, all for it to only be faster than 7% of users...

```java
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int value: nums)
        {
            if (counts.get(value) == null)
            {
                counts.put(value, 1);
            }
            else
            {
                counts.put(value, counts.get(value) + 1);
            }
        }
        ArrayList<ArrayList<Integer>> sorted = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < nums.length+1; i++)
        {
            sorted.add(null);
        }

        for (Integer value: counts.keySet())
        {
            if (sorted.get(counts.get(value)) == null)
            {
                ArrayList<Integer> values = new ArrayList<Integer>();
                values.add(value);
                sorted.set(counts.get(value), values);
            }
            else
            {
                ArrayList<Integer> newValues = sorted.get(counts.get(value));
                newValues.add(value);
                sorted.set(counts.get(value), newValues);
            }
        }

        int[] solution = new int[k];
        int outputted = 0;
        for (int j = sorted.size() - 1; j >= 0; j--) {
            if (sorted.get(j) != null)
            {
                for (int i = 0; i < sorted.get(j).size(); i++)
                {
                    solution[outputted] = sorted.get(j).get(i);
                    outputted++;
                    if (outputted == k)
                    {
                        return solution;
                    }
                }
            }
        }
        return null;
    }

}
```


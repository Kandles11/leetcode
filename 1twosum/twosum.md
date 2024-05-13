# Two Sum
`Sunday, May 12th, 2024 1:31:32AM`
Today is *Day Two* of leetcode (or should i say night, again...), and I got the fabled two sum problem. I had already seen discussion of the proper way to do this one, so I had a vague idea of how to approach. Going forward with the tried and true method of hashmaps, I gave this one a shot.

## Attempt 1
If you aren't familiar with two sum, here is the problem description:
```
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
```

This problem only took me one real attempt, so lets discuss the solution!

```java
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; i++)
        {
            if(map.get(nums[i]) == null)
            {
                map.put(target-(nums[i]), i);
            }
            else
            {
                int[] solution = {map.get(nums[i]), i};
                return solution;
            }
        }
        return null;
    }
}
```

Using the tried and true hashmap, we can solve this in O(n) time complexity! We go through each value in the nums array and check to see if it exists in the map. If not, we calculate what we would need to find moving forward. 
### For example:
Target: 9
Nums: [2,7,11,15]

2 -> Not in map, add (9-2) along with index
7 -> In the map! Found solution
return current index and mapped index

Final Map:
| key | value |
| --- | ----- |
|  7  |   0   |

The thing that helped the most is pen and paper. Being able to write down what values I expect in my map and what I'm looking for helped the most with this problem.

While having insight on the problem before helped, I'm glad I still got to practice the syntax and implementing the solution.
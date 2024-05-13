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
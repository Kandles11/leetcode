import java.util.HashMap;

class Solution {
	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> contents = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
		{
			if (contents.containsValue(nums[i]))
			{
				return true;
			}
			else
			{
				contents.put(i, nums[i]);
			}
		}
		return false;
	}
}
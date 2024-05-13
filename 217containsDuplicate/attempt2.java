import java.util.HashSet;

class Solution {
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> contents = new HashSet<Integer>();
		for (int value : nums)
		{
			if (contents.contains(value))
			{
				return true;
			}
			else
			{
				contents.add(value);
			}
		}
		return false;
	}
}
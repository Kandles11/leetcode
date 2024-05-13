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
                
            }
        }
    }
}
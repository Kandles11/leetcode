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
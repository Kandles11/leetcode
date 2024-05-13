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
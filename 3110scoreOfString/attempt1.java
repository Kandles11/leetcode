class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        int lastNum = s.charAt(0);
        for (int i = 1; i < s.length(); i++)
        {
            sum += Math.abs(lastNum - s.charAt(i));
            lastNum = s.charAt(i);
        }
        return sum;
    }
}
class Solution {
    public int appendCharacters(String s, String t) {
        int i =0;
        int k =0;
        for (i = 0; i < t.length(); i++)
        {  
            k = s.indexOf(t.charAt(i), k);
            if (k == -1)
            {
                return t.length() - i;
            }
        }
        return 0;
    }
}
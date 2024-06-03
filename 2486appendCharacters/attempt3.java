class Solution {
    public int appendCharacters(String s, String t) {
        int k =0;
        for (int i = 0; i < s.length(); i++)
        {  
           if (s.charAt(i) == t.charAt(k))
           {
            if(k == t.length()-1)
            {
                k++;
                break;
            }
            k++;
           }
        }
        return t.length() - k;
    }
}
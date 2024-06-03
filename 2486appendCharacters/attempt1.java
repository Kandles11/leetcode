class Solution {
    public int appendCharacters(String s, String t) {
        int i =0;
        //should find the max substring that's in S
        for(i =0; i <= t.length(); i++)
        {
            if (t.length() == 1)
            {
                if(!s.contains(t))
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
            else if(!s.contains(t.substring(0, i)))
            {
                i--;
                break;
            }
        }
        System.out.println("i is " + i);
        System.out.println("largest string is " + t.substring(0,i));
        return t.length() -i;
    }
}
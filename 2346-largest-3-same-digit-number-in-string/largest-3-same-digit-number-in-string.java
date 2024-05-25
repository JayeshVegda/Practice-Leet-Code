class Solution {
    public String largestGoodInteger(String num) 
    {
        String[] l = {"999", "888", "777" , "666", "555", "444", "333", "222", "111", "000"};
        for(int i = 0; i<l.length; i++)
        {
            if(num.contains(l[i]))
            {
                return l[i];
            }
        }

        return "";
    }
}
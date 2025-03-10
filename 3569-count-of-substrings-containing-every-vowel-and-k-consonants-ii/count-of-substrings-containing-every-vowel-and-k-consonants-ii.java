class Solution {
    public long count(String word, int k){
        int n = word.length() ;
        HashSet<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        HashMap<Character, Integer> mpp = new HashMap<>();
        int cons = 0;
        long res = 0;
        int j = 0;
        int i = 0;


        while(i < n)
        {
            char ch = word.charAt(i);

            if(vowel.contains(ch)){
                mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
            }else{
                cons++;
            }

            // shrinking
            while(mpp.size() == 5 && cons >= k)
            {
                res = res + (n - i);
                char nch = word.charAt(j);
                if(mpp.containsKey(nch)){
                    if(mpp.get(nch) == 1) mpp.remove(nch);
                    else mpp.put(nch, mpp.getOrDefault(nch, 0) - 1);
                }else{
                    cons--;
                }
                
                j++;
            }

            i++;
        }

        return res;

    }
    public long countOfSubstrings(String word, int k) 
    {
        return count(word, k) - count(word, k+1);

    }
}
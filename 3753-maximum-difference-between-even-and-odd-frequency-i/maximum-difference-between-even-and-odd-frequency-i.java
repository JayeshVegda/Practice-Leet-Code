class Solution {
    public int maxDifference(String s) 
    {
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;


        int[] freqo = new int[26];

        for(char ch : s.toCharArray()){
            int intCh = (char)(ch - 'a');
            freqo[intCh]++;
        }

        for(int i = 0; i < freqo.length; i++){
            int freq = freqo[i];
           if(freq > 0){
            if(freq % 2 == 0){
                if(freq < minEven){
                    minEven = freq;
                }
            }else{
                if(freq > maxOdd){
                    maxOdd = freq;
                }
            }
           }
        }

         if (maxOdd == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE) {
            return 0; 
        }

        return maxOdd - minEven;
    }
}
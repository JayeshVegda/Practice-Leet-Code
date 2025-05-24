class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) 
    {
        List<Integer> res = new ArrayList<>();
        int counter = 0;

        for(String str : words)
        {
            for(char ch : str.toCharArray()){
                if(ch == x) {
                    res.add(counter);
                    break;
                    }
            }

            counter++;
        }

        return res;
    }
}
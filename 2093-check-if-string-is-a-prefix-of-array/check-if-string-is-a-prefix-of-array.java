class Solution {
    public boolean isPrefixString(String s, String[] words) {
                int n = words.length;
        StringBuilder sb = new StringBuilder();

        int count = 0;

        while(count < n){
            sb.append(words[count]);

            if(s.equals(sb.toString())){
                return true;
            }
            count++;
        }
        return false;
    }
}
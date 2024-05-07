class Solution {
    public String reverseWords(String words) {
        String[] w = words.split(" ");
        int n = w.length;
        String[] rev = new String[n];
        
        StringBuilder real = new StringBuilder();
        for(int i = 0; i<n; i++){
            StringBuilder temp = new StringBuilder();
            temp.append(w[i]);
            temp.reverse();
            real.append(temp + " ");

        }

        
        return real.toString().trim();

    }
}
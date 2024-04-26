class Solution {
    public String truncateSentence(String s, int k) {
        String[] news = s.split(" ");
        StringBuilder mystring = new StringBuilder();
        for(int i = 0; i<k; i++){
            mystring.append(news[i] + " ");
        }


        return mystring.toString().trim();
    }
}
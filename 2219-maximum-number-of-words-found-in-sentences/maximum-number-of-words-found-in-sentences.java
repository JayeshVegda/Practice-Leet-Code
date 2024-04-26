class Solution {
    public int mostWordsFound(String[] sentences) {
    int space = 0;
        int n = sentences.length;
        for(int i = 0; i<n; i++){
            int temp = 0; /// --16156151 
            for(int j=0; j<sentences[i].length()-1; j++){
                if(sentences[i].charAt(j) == ' '){
                    temp++;
                }

                if(temp>=space){
                    space = temp;
                }
            }
        }
        return space + 1;
    }
}
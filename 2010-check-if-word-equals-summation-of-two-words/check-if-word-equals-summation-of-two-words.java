class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
         StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        StringBuilder tar = new StringBuilder();

        //First Word
        for(int i = 0; i<firstWord.length(); i++){
            int curr = firstWord.charAt(i) - 97;
            one.append(curr);
        }
        //Second Word
        for(int i = 0; i<secondWord.length(); i++){
            int curr = secondWord.charAt(i) - 97;
            two.append(curr);
        }
        //Target Word
        for(int i = 0; i<targetWord.length(); i++){
            int curr = targetWord.charAt(i) - 97;
            tar.append(curr);
        }


        int con_one = Integer.parseInt(one.toString());
        int con_two = Integer.parseInt(two.toString());
        int con_tar = Integer.parseInt(tar.toString());

        if(con_one + con_two == con_tar){
            return true;
        }

        return false;
    }
}
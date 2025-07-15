class Solution {
    public boolean length(String word) {
        if(word.length() >= 3) return true;

        return false;
    }

    public boolean atoz(String word)
    {
        boolean checkAtoZ = true;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

           if(ch == '@' || ch == '#' || ch == '$') return false;
        }
        
        return checkAtoZ ;
    }

    private boolean vowel(String word){
        for(int i = 0; i< word.length(); i++){
                 char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || 
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ){
                return true;
            }
        }

        return false;
    }

    private boolean hasConsonant(String word) {
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            
            if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' && 
            ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U' &&
            ch != '@' && ch != '#' && ch != '$' && 
            ch != '0' && ch != '1' && ch != '2' && ch != '3' && ch != '4' && 
            ch != '5' && ch != '6' && ch != '7' && ch != '8' && ch != '9') 
            {
                return true;  
            }
        }
        return false;  
    }

    public boolean isValid(String word) 
    {
        boolean len = length(word);
        boolean atoz = atoz(word);
        boolean vowel = vowel(word);
        boolean consonat = hasConsonant(word);

        System.out.println(len);
        System.out.println(atoz);
        System.out.println(vowel);
        System.out.println(consonat);
        return len && atoz && vowel && consonat;
    }
}
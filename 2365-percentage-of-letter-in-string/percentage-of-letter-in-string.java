class Solution {
    public int percentageLetter(String s, char letter) {
        
        int n = s.length();
        double counter = 0;
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == letter){
                counter++;
            }
        }

        return (int) counter * 100 / n  ;
    }
}
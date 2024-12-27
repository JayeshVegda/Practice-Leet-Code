class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        if(s.concat(s).contains(goal)) return true;

        // char first = goal.charAt(0);
        // char last = goal.charAt(goal.length() - 1);

       
        
        // for(int i = 1; i< s.length(); i++){
        //     char prev = s.charAt(i-1);
        //     char curr = s.charAt(i);

        //     if(curr == first && prev == last){
        //         return true;
        //     }
        // }
         
         return false;

    }
}
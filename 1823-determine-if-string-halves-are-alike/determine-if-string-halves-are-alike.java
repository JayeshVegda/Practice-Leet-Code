class Solution {
    public boolean halvesAreAlike(String s) {
         int n =  s.length();
        String one_s = s.substring(0, n/2).toLowerCase();
        String two_s = s.substring(n/2).toLowerCase();
        int n_one = one_s.length();
        int n_two = one_s.length();
        int one = 0;
        int two = 0;

        for(int i = 0; i<n_one; i++){
            char curr = one_s.charAt(i);
            if(curr == 'a' || curr == 'e' ||curr == 'i' ||curr == 'o' ||curr == 'u'){
                one++;
            }
        }

        for(int i = 0; i<n_two; i++){
            char curr = two_s.charAt(i);
            if(curr == 'a' || curr == 'e' ||curr == 'i' ||curr == 'o' ||curr == 'u'){
                two++;
            }
        }

        if(two == one){
            return true;
        }
        return false;
    }
}
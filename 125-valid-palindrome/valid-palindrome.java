class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int n = str.length();
        for(int i = 0; i<(str.length()/2); i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {

     int one_end = s.length();
        int two_end = t.length();

        if(one_end != two_end){
            return false;
        }

        int arr[] = new int[26];

        for(int i = 0; i<one_end; i++){
            arr[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i<two_end; i++){
            arr[t.charAt(i) - 'a']--;
            if(arr[t.charAt(i) - 'a'] < 0 ){
                return false;
            }


        }

        return true;

    }
}
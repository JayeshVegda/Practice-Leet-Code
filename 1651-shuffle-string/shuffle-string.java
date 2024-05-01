class Solution {
    public String restoreString(String s, int[] indices) {
       int n = indices.length;
       char a[] = new char[n];
       String o = "";

        for(int i = 0; i<n; i++){
            int ind = indices[i];
            a[ind] = s.charAt(i);
        }

        for(char i:a){
            o+=i;
        }

        return o;
        
    }


}
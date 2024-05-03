class Solution {
    public boolean checkRecord(String s) {
        int n = s.length();
        int abs = 0;
        int late = 0;


        // abs
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == 'A'){
                abs++;
            }
        }
        String l = "LLL";

        boolean b = s.contains(l);
        
        System.out.println(b);
        if(abs<2 && b == false){
            return true;
        }

        return false;
    }
}
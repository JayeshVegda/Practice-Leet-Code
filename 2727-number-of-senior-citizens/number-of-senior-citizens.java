class Solution {
    public int countSeniors(String[] s) {
        int counter = 0;
        for(String x : s){
            int o = x.charAt(11) - 48;
            int t = x.charAt(12) - 48;
            int age = o *10 + t;
            if(age > 60){
                counter++;
            }

        }

        return counter;
    }
}
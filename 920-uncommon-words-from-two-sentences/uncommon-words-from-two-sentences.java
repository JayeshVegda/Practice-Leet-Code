class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> mpp = new HashMap<>();
        String[] s01 = s1.split(" ");
        String[] s02 = s2.split(" ");
        for(String str : s01){
            if(mpp.containsKey(str)){
                mpp.put(str, mpp.getOrDefault(str, 0) - 1);
            }else{
                mpp.put(str, mpp.getOrDefault(str, 0) + 1);
            }
        }

        for(String str : s02){
            if(mpp.containsKey(str)){
                mpp.put(str, mpp.getOrDefault(str, 0) - 1);
            }else{
                mpp.put(str, mpp.getOrDefault(str, 0) + 1);
            }
        }

        ArrayList<String> str = new ArrayList<>();

        for(String key : mpp.keySet()){
            if(mpp.get(key) == 1){
                str.add(key);
            }
        }


        String[] res = new String[str.size()];

        for(int i = 0; i < str.size(); i++){
            res[i] = str.get(i);
        }

        return res;
    }
}
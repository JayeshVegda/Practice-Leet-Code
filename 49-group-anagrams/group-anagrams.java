class Solution {
    public String sort(String str){
        char[] cStr = str.toCharArray();
        Arrays.sort(cStr);

        return String.copyValueOf(cStr);

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mpp = new HashMap<>();

        for(String str : strs){
            String key = sort(str);

            if(!mpp.containsKey(key)){
                mpp.put(key, new ArrayList<>(List.of(str)));
            }else{
                mpp.get(key).add(str);
            }
        }

        return new ArrayList<>(mpp.values());
    }
}
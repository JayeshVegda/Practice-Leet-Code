class Solution {
    public static String sort(String str){
         char[] charArray = str.toCharArray();
         Arrays.sort(charArray);
        
        StringBuilder sortedString = new StringBuilder();
        for (char c : charArray) {
            sortedString.append(c);
        }

        return sortedString.toString();

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> listOfLists = new ArrayList<>();

        HashMap<String, ArrayList<String>> mpp = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String mystr = sort(strs[i]);
            if (!mpp.containsKey(mystr)) {
                mpp.put(mystr, new ArrayList<>());
                mpp.get(mystr).add(strs[i]);
            }else{
                mpp.get(mystr).add(strs[i]);
            }
        }

        List<List<String>> listOfLists = new ArrayList<>(mpp.values());
        System.out.println(listOfLists);
        return listOfLists;
    }
}
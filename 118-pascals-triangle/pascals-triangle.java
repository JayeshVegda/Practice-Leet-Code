class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        res.add(prev);

        for(int i = 1; i < numRows; i++){
            ArrayList<Integer> temp = new ArrayList<>();

            temp.add(1);

            for(int j = 1; j < i; j++){
                int desk  = prev.get(j) + prev.get(j-1);
                temp.add(desk);
            }

            temp.add(1);

            res.add(temp);
            prev = temp;
        }

        return res;
    }
}
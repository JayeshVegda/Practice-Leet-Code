class Solution {
    static List<List<Integer>> result = new ArrayList<>();
    public void help(int[] arr, int n, ArrayList<Integer> ans){
        
        if(n == arr.length) 
        {
            //ans [123]
            ArrayList<Integer>  copy = new ArrayList<>();
            for(int num : ans){
                copy.add(num);
            }

            result.add(copy);
            return;
        }


        int first = arr[n];
        ans.add(first);

        help(arr, n+1, ans);
        ans.remove(ans.size() - 1);
        help(arr, n+1, ans);

    }
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        help(nums, 0, new ArrayList<>());
        return result;
    }
}
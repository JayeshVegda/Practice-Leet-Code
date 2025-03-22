class Solution {
    public void dfs(int open, int close, String str, int n, List<String> res){
        if(open == close && open + close == n * 2){
            res.add(str);
            return;
        }

        if(open < n){
            dfs(open + 1, close, str + "(", n, res);
        }

        if(close < open){
            dfs(open, close + 1, str + ")", n, res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, "", n, res);
        return res;
    }
}
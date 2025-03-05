class Solution {
    public long coloredCells(int n) {
        if(n == 1) return 1;

        long faith = coloredCells(n-1);
        faith += (4 * n) - 4;

        return faith;
    }
}
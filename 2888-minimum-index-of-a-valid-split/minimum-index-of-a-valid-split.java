class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size(), candidates = nums.get(0), votes = 0;
        for (int i : nums) {
            if (i == candidates) votes++;
            else votes--;
            if (votes == 0) {
                candidates = i;
                votes = 1;
            }
        }

        int maxi = 0;
        for (int i : nums)
            if (i == candidates) maxi++;

        votes = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == candidates) votes++;
            if (votes * 2 > (i + 1) && (maxi - votes) * 2 > (n - i - 1)) return i;
        }
        return -1;
    }
}
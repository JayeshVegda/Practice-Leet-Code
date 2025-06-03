class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int i = m - 1; 
        int j = n - 1; 
        int k = m + n - 1; 

        while (i >= 0 && j >= 0) 
        {
            int val1 = nums1[i];
            int val2 = nums2[j];

            if (val1 > val2) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while(j >= 0){
            nums1[k--] =  nums2[j--];
        }
    }
}
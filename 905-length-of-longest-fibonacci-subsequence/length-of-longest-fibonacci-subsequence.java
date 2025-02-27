class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int max = 0;

        for(int i = 0; i < n - 1; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                int iVal = arr[i];
                int jVal = arr[j];
                int len = 2;

                while(set.contains(iVal + jVal))
                {
                    int temp = iVal + jVal;
                    iVal = jVal;
                    jVal = temp;
                    len++;
                }

                max = Math.max(len, max);
            }
        }

        return max > 2 ? max : 0;
    }
}
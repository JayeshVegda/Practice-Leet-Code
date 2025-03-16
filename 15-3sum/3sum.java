class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        while(i < n-2)
        {
            // check prev
          
                if (i > 0 && arr[i] == arr[i - 1]) 
                {
                    i++;
                    continue;
                }

            // set left and right pointer
            int left = i + 1;
            int right = n - 1;
            while(left < right)
            {
                int a = arr[i];
                int b = arr[left];
                int c= arr[right];
                int sum = a+b+c;
                
                if(sum == 0)
                {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    res.add(list);
                    // skip duplicate for second element;
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    
                    // Skip duplicates for third element
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
                else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
            i++;
        }

        return res;
    }
}
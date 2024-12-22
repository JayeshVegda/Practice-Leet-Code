class Solution {
    public void reverse(int[] num, int start, int end){
       int counter = start;
       while (end >= start){
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;

            end--;
            start++;
       }
    }
    public void rotate(int[] num, int k) {
     k = k % num.length;
     if(k <= 0) k+=num.length;

     reverse(num, 0, num.length - k-1);
     reverse(num, num.length - k, num.length-1);
     reverse(num, 0, num.length-1);

    }

}
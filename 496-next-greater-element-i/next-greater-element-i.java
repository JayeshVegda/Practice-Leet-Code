class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> sc = new Stack<>();
        HashMap<Integer, Integer> hc = new HashMap<>();

        for(int i = 0; i < nums2.length; i++){
            if(sc.isEmpty()){    
                sc.push(nums2[i]);
            }

            System.out.println(i+ ". " + (sc.peek() < nums2[i]));
            System.out.println("sc peek : " + sc.peek());
            System.out.println("num 2 val : " + nums2[i]);
            System.out.println();


            while(!sc.isEmpty() && sc.peek() < nums2[i]){
                int top = sc.pop();
                hc.put(top, nums2[i]);
            }

            sc.push(nums2[i]);
        }

        while(sc.size() != 0){
            hc.put(sc.pop(), -1);
        }

        for(int i = 0; i<nums1.length; i++){
            nums1[i] = hc.get(nums1[i]);
        }

        return nums1;
    }
}
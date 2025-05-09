
class Solution {

    public List<Integer> eventualSafeNodes(int[][] g) 
    {
        int n = g.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
           adj.add(new ArrayList<Integer>());
        }



        // calling bfs
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] inDeg = new int[n];

        // step 1 : find inDegree
        for (int u = 0; u < n; u++) {
            for (int v : g[u]) {
                adj.get(v).add(u);
                inDeg[u]++;
            }
        }

        // finding node with 0 and adding in queue
        for(int i = 0; i < n; i++){
            if(inDeg[i] == 0) q.add(i);
        }


        // impliment bfs
        boolean[] safe = new boolean[n];
        while(!q.isEmpty()){
            int rem = q.poll();
            safe[rem] = true;

            for(int neg : adj.get(rem)){
                inDeg[neg]--;
                if(inDeg[neg]==0) q.add(neg);
            }
        }

        for(int i = 0; i < n; i++){
            if(safe[i]  ) res.add(i);
        }


        return res;
    }
}
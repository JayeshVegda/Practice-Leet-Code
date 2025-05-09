
class Graph{
    int n;
    List<List<Integer>> adj;
    List<Integer> topo = new ArrayList<>();

    Graph(int n){
        this.n = n;
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    
    public void adder(int src, int dest){
        adj.get(src).add(dest);
    }
    

    public boolean helper()
    {
        int[] inDeg = new int[n];

        // step 1 : find indegree
        for(int i = 0; i < n; i++){
            for(int neg : adj.get(i)){
                inDeg[neg]++;
            }
        }

        // step 2 : add 0 in queue
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        // Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            if(inDeg[i] == 0) q.add(i);
        }
        
        // step 3 : impiment bfs
        while(!q.isEmpty())
        {
            int rem = q.poll();

            for(int neg : adj.get(rem)){
                inDeg[neg]--;
                if(inDeg[neg] == 0) q.add(neg);
            }

            count++;
        }

        // step 4 :
        return count == n;
    }


}

class Solution {
    public boolean canFinish(int V, int[][] edges) 
    {
        Graph g = new Graph(V);
        
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            
            g.adder(src, dest);
        }
        
        return g.helper();
        
    }
}
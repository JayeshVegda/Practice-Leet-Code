class Pair{
    int stops;
    int node;
    int dist;

    Pair(int stops, int node, int dist){
        this.stops = stops;
        this.node = node;
        this.dist = dist;
    }
}

class GPair{
    int node;
    int w;

    GPair(int node, int w){
        this.node = node;
        this.w = w;
    }
}

class Graph{
    int n;
    List<List<GPair>> adj;

    Graph(int n){
        this.n = n;
        this.adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<GPair>());
        }
    }

    void adder(int src, int dest, int w){
        adj.get(src).add(new GPair(dest, w));
    }

    int helper(int src, int dest, int stop)
    {

        int[] distArr = new int[n];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[src] = 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, src, 0));

        while(!q.isEmpty()){
            Pair rem = q.poll();

            // Pair Property
            int stops = rem.stops;
            int node = rem.node;
            int dist = rem.dist;
            if(stops > stop + 1 ) continue;

            for(GPair neg : adj.get(node)){
                int gNode = neg.node;
                int gW = neg.w;

                if(dist + gW < distArr[gNode] && stops <= stop){
                    distArr[gNode] = dist +gW;
                    q.add(new Pair(stops + 1, gNode, dist + gW));
                }
            }
        }
        

        return distArr[dest] == Integer.MAX_VALUE ? -1 : distArr[dest];
    }

}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        Graph g = new Graph(n);

        for(int i = 0; i < flights.length; i++){
            int srco = flights[i][0];
            int desto = flights[i][1];
            int wo = flights[i][2];

            g.adder(srco, desto, wo);
        }

        return g.helper(src, dst, k);

    }
}
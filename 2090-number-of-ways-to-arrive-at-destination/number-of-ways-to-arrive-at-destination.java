class GPair{
    int dest;
    int w;

    GPair(int dest, int w){
        this.dest = dest;
        this.w = w;
    }
}

class Pair{
    long dist;
    int node;

    Pair(long dist, int node){
        this.dist = dist;
        this.node = node;
    }
}

class Graph{
    int n;
    List<List<GPair>> adj;

    Graph(int n){
        this.n = n;
        this.adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
    }

    void adder(int src, int dest, int w){
        adj.get(src).add(new GPair(dest, w));
        adj.get(dest).add(new GPair(src, w));
    }

    int djk(){
        long[] distArr = new long[n];
        long[] ways = new long[n];
        Arrays.fill(distArr, Long.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        distArr[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty())
        {
            Pair rem = pq.poll();

            long  remDist = rem.dist; // 0
            int remNode = rem.node; // 0

            for(GPair neb : adj.get(remNode))
            {
                int nebNode = neb.dest; // 1
                int nebDist = neb.w; // 1 
                long newDist = nebDist + remDist; // 0 + 1


                if(newDist == distArr[nebNode])
                {
                    ways[nebNode] = (ways[nebNode] + ways[remNode]) % 1_000_000_007;
                }

                if(newDist < distArr[nebNode]) 
                {
                    ways[nebNode] = ways[remNode] % 1_000_000_007;
                    distArr[nebNode] = newDist;

                    pq.add(new Pair(newDist, nebNode));                    
                }

            }
        }

        return (int) ways[n - 1];
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        Graph g = new Graph(n);
        
        for(int i = 0; i < roads.length; i++){
            int src = roads[i][0];
            int dest = roads[i][1];
            int w = roads[i][2];

            g.adder(src, dest, w);
        }


        return g.djk();

    }
}
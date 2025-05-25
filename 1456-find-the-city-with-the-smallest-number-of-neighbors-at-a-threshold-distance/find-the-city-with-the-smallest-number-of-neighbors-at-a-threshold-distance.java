class Pair{
    int node;
    int w;

    Pair(int node, int w){
        this.node = node;
        this.w = w;
    }
}
class Graph{
    int n;
    int[][] mat;
    
    Graph(int n){
        this.n = n;
        mat = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                mat[i][j] = (int) 1e8;
            }
        }

    }

    void adder(int src, int dest, int w)
    {
        mat[src][dest] = w;
        mat[dest][src] = w;
    }

    void floyd()
    {
        for(int via = 0; via < n; via++)
        {
            for(int row = 0; row < n; row++)
            {
                for(int col = 0; col < n; col++)
                {
                    if(row == col){
                        mat[row][col] = 0;
                        continue;
                    }
                    if(mat[row][via] != 1e8 && mat[via][col]!= 1e8)
                        mat[row][col] = Math.min(mat[row][col], mat[via][col] + mat[row][via]);
                }
            }
        }
    }
    int threser(int stop){
        int currMin = stop;
        int city = -1;

        for(int row = 0; row < n; row++)
        {   
            int currCity = 0;
            for(int col = 0; col < n; col++)
            {
                if(mat[row][col] <= stop){
                    currCity++;
                }
            }

            if(currCity <= currMin)
            {
                currMin = currCity;
                city = row;
            }
        }

        return city;
    }
    void printer(){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) 
    {
        Graph g = new Graph(n);

        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            int w = edges[i][2];

            g.adder(src, dest, w);
        }

        g.printer();
        g.floyd();
        g.printer();

        return g.threser(distanceThreshold);

    }
}
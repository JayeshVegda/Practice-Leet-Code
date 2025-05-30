class DSU{
    int[] rank;
    int[] parent;
    int comp = 0;
    int n;
    DSU(int n){
        this.n = n;
        rank = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }

    int findParent(int node){
        if(node == parent[node]){
            return node;
        }

        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    void adder(int u, int v){
        int s1 = findParent(u);
        int s2 = findParent(v);

        if(s1 == s2) return;

        if(rank[s1] < rank[s2]){
            parent[s1] = s2;
        }else if(rank[s2] < rank[s1]){
            parent[s2] = s1;
        }else{
            parent[s2] = s1;
            rank[s1]++;
        }
    }
 
    int findComp(){
        int extra = 0;
        for(int i = 0; i < n; i++){
            if(parent[i] == i) extra ++;
        }
        return extra;
    }

    void printer(){
        System.out.print("Rank : ");
        for(int i = 0; i < n; i++){
            System.out.print(rank[i] + " ");
        }
        System.out.println();
        System.out.print("Parent : ");
        for(int i = 0; i < n; i++){
            System.out.print(parent[i] + " ");
        }
    }


}

class Solution {
    public int makeConnected(int n, int[][] mat) 
    {
        DSU dsu = new DSU(n);
        int extra = 0;

        for(int i = 0; i < mat.length; i++){
            int src = mat[i][0];
            int dest = mat[i][1];

            if(dsu.findParent(src) == dsu.findParent(dest)){
                extra++;
            }else{
                dsu.adder(src, dest);
            }
        }
        int comp = dsu.findComp();
        System.out.println(extra +" "+  comp);
        if(extra >= comp - 1){
            return comp - 1;
        }else{
            return -1;
        }
    }
}
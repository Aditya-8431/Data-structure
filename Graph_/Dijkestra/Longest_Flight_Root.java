package Graph_.Dijkestra;
import java.util.*;
public class Longest_Flight_Root {
    static boolean[] vis;
    int n, m;
    
    static int indgree[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        indgree = new int[n+1];
        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            indgree[v]++;
        }
        int[] parent = new int[n + 1];
        int[] dp = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indgree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> topoSort = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topoSort.add(node);
            for(int neighbor: adj.get(node)){
                indgree[neighbor]--;
                if(indgree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        for(int i=0;i<topoSort.size();i++){
            if(topoSort.get(i)==0){
                continue;
            }
            int node=topoSort.get(i);
            
            for(int x:adj.get(node)){
                if(dp[node]+1>dp[x]){
                    dp[x]=Math.max(dp[x],dp[node]+1);
                    parent[x]=node;
                }
                
            }
            
        }
        if(dp[n]==0){
            System.out.println("IMPOSSIBLE");
            return;
        }
        
       //making path
          
        ArrayList<Integer> path = new ArrayList<>();
        int node = n;

        while (node != 0) {
            path.add(node);
            node = parent[node];
        }

        Collections.reverse(path);

        System.out.println(path.size());
        for (int x : path) {
            System.out.print(x + " ");
        }
    }
}

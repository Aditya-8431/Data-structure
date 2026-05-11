package Graph_.DFS;
import java.util.*;
public class Ice_Skating_CF {
    public static int countComponents(int[][] edges,int V){
        int count=0;
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(edges,i,vis);
            }
        }
        return count-1;
    }
    public static void dfs(int[][] edges,int curr,boolean[] vis){
        vis[curr]=true;
        for(int i=0;i<edges.length;i++){
            if(edges[curr][i]==1 && !vis[i]){
                dfs(edges,i,vis);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] edges=new int[n][2];
        for(int i=0;i<n;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
        }
        int V=n;
        int ans=countComponents(edges,V);
        System.out.println(ans);
    }
}

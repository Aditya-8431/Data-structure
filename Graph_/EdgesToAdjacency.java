package Graph_;
import java.util.*;
public class EdgesToAdjacency {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
         int m=sc.nextInt();
        int[][] edges=new int[m][2];
        for(int i=0;i<m;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> adj=edgesToAdjacencyList(n,edges);
        for(int i=0;i<adj.size();i++){
            System.out.print(i+"->");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> edgesToAdjacencyList(int n,int[][] edges){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
        
    }
}

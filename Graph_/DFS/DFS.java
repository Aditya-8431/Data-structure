package Graph_.DFS;
import java.util.*;
public class DFS {
    static class Edge{
        int src;
        int dest;
        
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
            
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));

        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

         
        
    }
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        //System.out.print(curr+"->");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void dfsReturn(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        // ans.add(curr);
        System.out.println(curr+" ");
        vis[curr]=true;
        for(Edge e:graph[curr]){
           
            if(!vis[e.dest]){
                dfsReturn(graph, e.dest, vis);
            }
        }
        
    }
    public static int countConnectedComponents(ArrayList<Edge>[] graph){
        boolean[] vis=new boolean[graph.length];
        int count=0;
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfs(graph, i, vis);
                count++;
            }
        }
        return count;
    }
    public static void printconCom(ArrayList<Edge>[] graph){
        
        boolean[] vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                System.out.println("Comp: ");
                dfsReturn(graph,i,vis);
                System.out.println();
            }
        }
    }
    // public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
    //     if(src==dest){
    //         return true;
    //     }
    //     vis[src]=true;
    //     for(int i=0;i<graph[src].size();i++){
    //         Edge e=graph[src].get(i);
    //         if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public static void main(String[] args) {
        int V=8;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        boolean[] vis=new boolean[V];
        dfs(graph, 0, vis);
        ArrayList<Integer> ans=new ArrayList<>();
        boolean[] vis2=new boolean[V];
     
        // ans=dfsReturn(graph, 0, vis2, ans);
        int count=countConnectedComponents(graph);
        System.out.println("Total connected componet" + count);
        printconCom(graph);

       
    }
}

package Graph_.DFS;
import java.util.*;
public class ConnectedComponents {
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
    }
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis, ArrayList<Integer> component){
        vis[curr]=true;
        component.add(curr);
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis, component);
            }
        }
    }
    public static int totleComponents(ArrayList<Edge>[] graph){
        boolean[] vis=new boolean[graph.length];
        int count=0;
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                ArrayList<Integer> component=new ArrayList<>();
                dfs(graph, i, vis, component);
                System.out.println("Component "+count+": "+component);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        int components=totleComponents(graph);
        System.out.println("Total Connected Components: "+components);
    }
}

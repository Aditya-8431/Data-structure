package Graph_.BFS;
import java.util.*;
public class BFS_level {
   static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 5, 4));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 4));
        graph[4].add(new Edge(4, 5, 4));

        graph[5].add(new Edge(5, 2, 4));
        graph[5].add(new Edge(5, 4, 4));

    }
    public static void bfslevel(ArrayList<Edge>[] graph,int src){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        int[] levelArr=new int[graph.length];
        levelArr[src]=0;
        q.add(src);
        while (!q.isEmpty()) {
            int curr = q.remove();
            
            if (!vis[curr]) {
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    if(!vis[e.dest]){
                        levelArr[e.dest]=levelArr[curr]+1;
                        q.add(e.dest);
                    }
                }
                vis[curr] = true;
                for(int i=0;i<levelArr.length;i++){
                    System.out.print(levelArr[i]+" ");
                }

            }
        
        }
        
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src=0;
        bfslevel(graph,src);
        //System.out.println("Level of the graph is "+ans);
    }
}

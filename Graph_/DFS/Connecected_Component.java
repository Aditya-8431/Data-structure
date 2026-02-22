package Graph_.DFS;
import java.util.*;
class Solution {
    // Function to find the connected components in an undirected graph in gfg.
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> graph = buildGraph(V, edges);
        ArrayList<ArrayList<Integer>> allComponents = new ArrayList<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i, graph, vis, comp);
                allComponents.add(comp);
            }
        }
        return allComponents;
    }

    private ArrayList<ArrayList<Integer>> buildGraph(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return graph;
    }

    private void dfs(int curr, ArrayList<ArrayList<Integer>> graph,
                     boolean[] vis, ArrayList<Integer> comp) {

        vis[curr] = true;
        comp.add(curr);

        for (int nbr : graph.get(curr)) {
            if (!vis[nbr]) dfs(nbr, graph, vis, comp);
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int V = 5;  
        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> components = sol.getComponents(V, edges);
        System.out.println(components);
    }
}

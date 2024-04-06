package DAY_02;

import java.util.*;

 class DFS {
    static List<List<Integer>> graph;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList<>(n);
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); 
        }
        dfs(0);
        
        scanner.close();
    }
}


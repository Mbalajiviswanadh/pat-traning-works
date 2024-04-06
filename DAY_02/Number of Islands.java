package DAY_02;

import java.util.Scanner;

class Number_ofIslands {
    
    public static int countIslands(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    public static void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }
        
        grid[i][j] = 0;
        
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
        dfs(grid, i + 1, j + 1); // diagonal down-right
        dfs(grid, i + 1, j - 1); // diagonal down-left
        dfs(grid, i - 1, j + 1); // diagonal up-right
        dfs(grid, i - 1, j - 1); // diagonal up-left
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println(countIslands(grid));
        scanner.close();
    }
}


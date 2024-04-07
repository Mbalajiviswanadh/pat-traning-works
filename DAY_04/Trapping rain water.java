package DAY_04;
import java.util.*;

class Trappingrain_water {

    public static int trappedWater(int heights[], int n) {
        int totalWater = 0;

        if (n <= 2) // Not enough bars to trap water
            return totalWater;

        
        // array to store the maximum height to the left of each bar
        int leftMax[] = new int[n]; 
        // array to store the maximum height to the right of each bar
        int rightMax[] = new int[n]; 

        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }
        for (int i = 0; i < n; i++) {
            totalWater += Math.max(0, Math.min(leftMax[i], rightMax[i]) - heights[i]);
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int heights[] = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.println(trappedWater(heights, n));
        sc.close();
    }
}

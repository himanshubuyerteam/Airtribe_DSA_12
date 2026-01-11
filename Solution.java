import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] flowers = new int[n];
        
        for (int i = 0; i < n; i++) {
            flowers[i] = sc.nextInt();
        }
        
        // Sort in descending order
        Arrays.sort(flowers);
        int idx = n - 1;
        
        long total = 0;
        int multiplier = k;
        
        // Pick k biggest values with multipliers
        while (multiplier > 0 && idx >= 0) {
            total += (long) flowers[idx] * multiplier;
            idx--;
            multiplier--;
        }
        
        System.out.println(total);
    }
}

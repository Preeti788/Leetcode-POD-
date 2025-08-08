class Solution {
   
    private double[][] memo;
    private final int[] da = {4, 3, 2, 1};
    private final int[] db = {0, 1, 2, 3};

    public double soupServings(int n) {
       
        int unit = (n + 24) / 25; 
        if (unit >= 200) return 1.0;

        memo = new double[unit + 1][unit + 1];
        for (int i = 0; i <= unit; i++) {
            for (int j = 0; j <= unit; j++) memo[i][j] = -1.0;
        }

        return dp(unit, unit);
    }

    private double dp(int a, int b) {

        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (memo[a][b] >= 0) return memo[a][b];

        double prob = 0.0;
        for (int k = 0; k < 4; k++) {
            int na = a - da[k];
            int nb = b - db[k];
            prob += 0.25 * dp(Math.max(na, 0), Math.max(nb, 0));
        }

        memo[a][b] = prob;
        return prob;
    }
}

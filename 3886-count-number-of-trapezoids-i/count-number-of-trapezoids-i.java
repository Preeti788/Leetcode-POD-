class Solution {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1_000_000_007;

        Map<Integer, Integer> countY = new HashMap<>();
        for (int[] p : points) {
            countY.put(p[1], countY.getOrDefault(p[1], 0) + 1);
        }

        long sumH = 0; 
        long sumH2 = 0;

        for (int cnt : countY.values()) {
            if (cnt >= 2) {
                long h = (long) cnt * (cnt - 1) / 2; // C(cnt, 2)
                sumH = (sumH + h) % MOD;
                sumH2 = (sumH2 + h * h) % MOD;
            }
        }

        long ans = (sumH * sumH % MOD - sumH2 + MOD) % MOD;
        ans = ans * ((MOD + 1) / 2) % MOD;  // divide by 2 with modular inverse

        return (int) ans;
    }
}

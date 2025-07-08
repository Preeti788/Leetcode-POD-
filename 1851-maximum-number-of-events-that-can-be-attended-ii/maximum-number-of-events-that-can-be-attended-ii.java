class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        int[] endDays = new int[n];
        for (int i = 0; i < n; i++) {
            endDays[i] = events[i][1];
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int[] currEvent = events[i - 1];
            int start = currEvent[0];
            int end = currEvent[1];
            int value = currEvent[2];

    
            int prevIndex = binarySearch(events, start, i - 1);

            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

            
                dp[i][j] = Math.max(dp[i][j], dp[prevIndex + 1][j - 1] + value);
            }
        }

        return dp[n][k];
    }


    private int binarySearch(int[][] events, int start, int rightBound) {
        int low = 0, high = rightBound - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (events[mid][1] < start) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}

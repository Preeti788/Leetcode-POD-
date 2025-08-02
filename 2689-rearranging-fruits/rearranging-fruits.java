class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int minVal = Integer.MAX_VALUE;

        for (int x : basket1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            minVal = Math.min(minVal, x);
        }

        for (int x : basket2) {
            freq.put(x, freq.getOrDefault(x, 0) - 1);
            minVal = Math.min(minVal, x);
        }

        List<Integer> extra = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int count = e.getValue();
            if (count % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                extra.add(e.getKey());
            }
        }

        Collections.sort(extra);
        long cost = 0;
        int m = extra.size();
        for (int i = 0; i < m / 2; i++) {
            cost += Math.min(extra.get(i), 2 * minVal);
        }

        return cost;
    }
}

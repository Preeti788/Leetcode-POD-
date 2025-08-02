class Solution {
    public long minCost(int[] basket1, int[] basket2) {
    
        Map<Integer, Integer> count = new TreeMap<>();
        int n = basket1.length;
    
        for (int val : basket1) count.put(val, count.getOrDefault(val, 0) + 1);
        for (int val : basket2) count.put(val, count.getOrDefault(val, 0) - 1);

        List<Integer> extra = new ArrayList<>();
        long minElement = Long.MAX_VALUE;

        for (int key : count.keySet()) {
            int freq = count.get(key);

            if (freq % 2 != 0) return -1; 

            int half = Math.abs(freq) / 2;
            for (int i = 0; i < half; i++) {
                extra.add(key);
            }
            minElement = Math.min(minElement, key);
        }

        Collections.sort(extra);

        long cost = 0;
        for (int i = 0; i < extra.size() / 2; i++) {
            cost += Math.min(extra.get(i), 2 * minElement);
        }

        return cost;
    }
}

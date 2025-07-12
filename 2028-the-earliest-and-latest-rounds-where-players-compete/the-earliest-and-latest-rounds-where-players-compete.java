class Solution {

    private int minRound = Integer.MAX_VALUE;
    private int maxRound = Integer.MIN_VALUE;
    private Map<String, boolean[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        dfs(1, getSortedArray(n), firstPlayer, secondPlayer);
        return new int[]{minRound, maxRound};
    }

    private void dfs(int round, List<Integer> players, int f, int s) {
        int l = players.size();
        for (int i = 0; i < l / 2; i++) {
            int a = players.get(i), b = players.get(l - 1 - i);
            if ((a == f && b == s) || (a == s && b == f)) {
                minRound = Math.min(minRound, round);
                maxRound = Math.max(maxRound, round);
                return;
            }
        }

        List<int[]> matches = new ArrayList<>();
        int i = 0, j = players.size() - 1;
        while (i < j) {
            matches.add(new int[]{players.get(i), players.get(j)});
            i++;
            j--;
        }
        Integer mid = (i == j) ? players.get(i) : null;

        dfsMatch(round, matches, 0, new HashSet<>(), mid, f, s);
    }

    private void dfsMatch(int round, List<int[]> matches, int idx, Set<Integer> next, Integer mid, int f, int s) {
        if (idx == matches.size()) {
            if (mid != null) next.add(mid);
            List<Integer> newList = new ArrayList<>(next);
            Collections.sort(newList);
            dfs(round + 1, newList, f, s);
            return;
        }

        int[] pair = matches.get(idx);
        int a = pair[0], b = pair[1];

        if ((a == f || a == s) && !(b == f || b == s)) {
            next.add(a); 
            dfsMatch(round, matches, idx + 1, next, mid, f, s);
            next.remove(a);
        } else if ((b == f || b == s) && !(a == f || a == s)) {
            next.add(b); 
            dfsMatch(round, matches, idx + 1, next, mid, f, s);
            next.remove(b);
        } else if ((a == f && b == s) || (a == s && b == f)) {
            return;
        } else {
            next.add(a);
            dfsMatch(round, matches, idx + 1, next, mid, f, s);
            next.remove(a);

            next.add(b);
            dfsMatch(round, matches, idx + 1, next, mid, f, s);
            next.remove(b);
        }
    }

    private List<Integer> getSortedArray(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) res.add(i);
        return res;
    }
}

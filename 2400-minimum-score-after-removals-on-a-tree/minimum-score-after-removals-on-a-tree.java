class Solution {
    int[] parent, in, out, subtreeXor;
    int time = 0;
    List<Integer>[] tree;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        parent = new int[n];
        in = new int[n];
        out = new int[n];
        subtreeXor = new int[n];


        dfs(0, -1, nums);

        int totalXor = subtreeXor[0];
        int minScore = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; i++) {
            int a = getChild(edges[i][0], edges[i][1]);
            for (int j = i + 1; j < edges.length; j++) {
                int b = getChild(edges[j][0], edges[j][1]);

                int xor1 = subtreeXor[a];
                int xor2 = subtreeXor[b];
                int xor3;

                if (isAncestor(a, b)) {
                    xor2 = subtreeXor[b];
                    xor1 = subtreeXor[a] ^ xor2;
                    xor3 = totalXor ^ subtreeXor[a];
                } else if (isAncestor(b, a)) {
                    xor1 = subtreeXor[a];
                    xor2 = subtreeXor[b] ^ xor1;
                    xor3 = totalXor ^ subtreeXor[b];
                } else {
                    xor3 = totalXor ^ xor1 ^ xor2;
                }

                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));
                minScore = Math.min(minScore, max - min);
            }
        }

        return minScore;
    }

    void dfs(int node, int par, int[] nums) {
        in[node] = time++;
        parent[node] = par;
        subtreeXor[node] = nums[node];
        for (int nei : tree[node]) {
            if (nei == par) continue;
            dfs(nei, node, nums);
            subtreeXor[node] ^= subtreeXor[nei];
        }
        out[node] = time++;
    }

    boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[u] >= out[v];
    }

    int getChild(int u, int v) {
        return parent[u] == v ? u : v;
    }
}

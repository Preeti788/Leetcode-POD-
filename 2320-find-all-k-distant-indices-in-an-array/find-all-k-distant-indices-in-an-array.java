class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        Set<Integer> result = new HashSet<>();
        int n = nums.length;

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(n - 1, j + k);
                for (int i = start; i <= end; i++) {
                    result.add(i);
                }
            }
        }

    
        List<Integer> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }
}

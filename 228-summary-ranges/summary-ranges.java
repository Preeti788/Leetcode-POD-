class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;

        if (n == 0) return result;

        int start = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                // Build the string more efficiently
                result.add(buildRange(start, nums[i - 1]));
                start = nums[i];
            }
        }


        result.add(buildRange(start, nums[n - 1]));
        return result;
    }

    private String buildRange(int start, int end) {
        if (start == end) return Integer.toString(start);
        StringBuilder sb = new StringBuilder();
        sb.append(start).append("->").append(end);
        return sb.toString();
    }
}

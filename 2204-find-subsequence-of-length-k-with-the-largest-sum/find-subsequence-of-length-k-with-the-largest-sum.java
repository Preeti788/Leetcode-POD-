class Solution {
    public int[] maxSubsequence(int[] nums, int k) {


        int n = nums.length;
        int[][] valueIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            valueIndex[i][0] = nums[i]; 
            valueIndex[i][1] = i;       
        }

        Arrays.sort(valueIndex, (a, b) -> b[0] - a[0]);

        int[][] topK = new int[k][2];
        for (int i = 0; i < k; i++) {
            topK[i] = valueIndex[i];
        }


        Arrays.sort(topK, (a, b) -> a[1] - b[1]);

        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][0];
        }

        return result;
    }
}

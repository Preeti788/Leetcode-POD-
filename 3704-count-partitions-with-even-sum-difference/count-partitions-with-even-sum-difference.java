class Solution {
    public int countPartitions(int[] nums) {
       int n = nums.length;

       int total = 0;
       for(int x : nums) total += x;

       if(total % 2 == 1) return 0;

       return n - 1;
    }
}

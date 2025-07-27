class Solution {
    public int countHillValley(int[] nums) {
        int indicator = -1; // 1 -> upphill 0 -> downhill -1 -> plane
        int count = 0;
        int n = nums.length;

        for(int i = 1 ; i < n ; i++){
            if(nums[i] > nums[i-1]){
                if(indicator == 0)count+=1;
                indicator = 1;
            }
            else if(nums[i] < nums[i-1]){
                if(indicator == 1)count+=1;
                indicator = 0;
            }
        }

        return count;
    }
}

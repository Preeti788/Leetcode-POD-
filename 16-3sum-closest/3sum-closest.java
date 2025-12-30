class Solution {
    private void bubbleSort(int[] nums){
        int n = nums.length;
        boolean swapped;
        for(int i = 0; i < n - 1; i++){
            swapped = false;
            for(int j=0; j<n-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                }
            }

            if(!swapped) break;
        }


    }

    public int threeSumClosest(int[] nums, int target){
        bubbleSort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i=0; i<n-2; i++){
            int left = i+1;
            int right = n-1;

            while (left < right){
                int currentSum = nums[i] + nums[left] + nums[right];

                if(Math.abs(currentSum - target) < Math.abs(closestSum - target)){
                    closestSum = currentSum;
                }

                if(currentSum < target){
                    left++;
                }else if (currentSum > target){
                    right--;
                }else{
                    return currentSum;
                }
            }
        }

        return closestSum;
    }
        
        
    
}
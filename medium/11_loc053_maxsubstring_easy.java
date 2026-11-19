class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize both trackers with the first element
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the existing subarray or start fresh at nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the global maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        // 'k' tracks the index for the next element that doesn't equal 'val'
        int k = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Keep the element if it is not the target value
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k;
    }
}

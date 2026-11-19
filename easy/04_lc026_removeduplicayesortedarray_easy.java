class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        // 'k' tracks the position for the next unique element
        int k = 1;
        
        for (int i = 1; i < nums.length; i++) {
            // When a new unique value is found, place it at index 'k'
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k;
    }
}

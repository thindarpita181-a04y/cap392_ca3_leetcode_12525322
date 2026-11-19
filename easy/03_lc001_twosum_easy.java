import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            
            // Return indices if the matching number was already seen
            if (seen.containsKey(needed)) {
                return new int[] { seen.get(needed), i };
            }
            
            // Otherwise, store the current number and its index
            seen.put(nums[i], i);
        }
        
        return new int[] {}; 
    }
}

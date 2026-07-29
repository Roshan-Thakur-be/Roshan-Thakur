class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        return Math.max(robSimple(nums, 0, nums.length - 2), 
                        robSimple(nums, 1, nums.length - 1));
    }
    
    private int robSimple(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }
        
        return prev1;
    }
}
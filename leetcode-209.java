class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        long Sum = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            Sum += nums[i];

            while (Sum >= target) {
                min = Math.min(min, i - left + 1);
                Sum -= nums[left];
                left++;
            }
        }

        
        int finalResult;

        if (min == Integer.MAX_VALUE) { 
            finalResult = 0; 
        } else {
            finalResult = min; 
        }

        return finalResult; 
    }
}

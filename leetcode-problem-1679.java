class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int operations = 0;
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int currentsum = nums[left] + nums[right];
            if(currentsum == k){
                operations++;
                left++;
                right--;
            }
            else if(currentsum < k){
                left++;
            }
            else{
                right--;
            }
        }
        return operations;
    }
}

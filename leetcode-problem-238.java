class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int prefixpoint = 1;
        for(int i=0;i<n;i++){
            ans[i] = prefixpoint;
            prefixpoint *= nums[i];
        }

        int suffixpoint = 1;
        for(int i=n-1;i>=0;i--){
            ans[i] *= suffixpoint;
            suffixpoint *= nums[i];
        }
        return ans;
    }
}

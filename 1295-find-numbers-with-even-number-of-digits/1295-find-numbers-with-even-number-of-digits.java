class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n ; i++){
            String s = Integer.toString(nums[i]);
            if(s.length()%2==0){
                ans++;
            }
        }
        return ans;
    }
}
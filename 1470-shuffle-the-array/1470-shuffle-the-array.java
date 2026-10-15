class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[2*n];
        /*
        for(int i=0; i<n/2 ; i++){
            ans[i] = nums[i];
        }
        for(int j=0;j<n/2;j++){
            ans[j+(n/2)] = nums[j+(n/2)];
        }*/
        for(int i=0; i<n ; i++){
            ans[2*i] = nums[i];
            ans[2*i+1] = nums[i+n];
        }
            return ans;
    }
}
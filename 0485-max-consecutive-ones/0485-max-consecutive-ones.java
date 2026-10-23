class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int total = 0;
        int min = Integer.MIN_VALUE;
        for(int i=0; i<n ; i++){
            if(nums[i]==1){
                sum=sum+nums[i];
                if(sum>total){
                    total=sum;
                }
                }
            else{
                sum = 0;
            }
        }
        return total;
    }
}
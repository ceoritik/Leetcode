import java.util.Arrays;
class Solution{
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (nums[i] + nums[j] == target){
                return new int[]{i,j};
            }
        }
    }
    return new int[]{};
}
public static void main(String[] args){
    int[] nums = {1, 3, 5, 2, 4, 1};
    int target = 5;

    Solution s = new Solution();
    int[] result = s.twoSum(nums, target);
    System.out.println(Arrays.toString(result));
}
}
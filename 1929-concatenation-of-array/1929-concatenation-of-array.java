class Solution {
    public int[] getConcatenation(int[] nums) {
        int answer[] = new int[2 *nums.length];
        int n = nums.length;
        for(int i=0; i < nums.length ; i++){
            answer[i] = answer[i+n] = nums[i];
    }
    return answer;
}
}
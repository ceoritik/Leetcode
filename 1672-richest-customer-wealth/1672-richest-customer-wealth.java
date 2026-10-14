class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum = 0;
        int max=0;
        int rows = accounts.length;
        int col = accounts[0].length;
        for(int i = 0; i < rows; i++){
            sum=0;
            for (int j=0; j< col; j++){
                sum = sum + accounts[i][j];
            }
            if(sum>max) max=sum;      
        }
        return max;
    }
}
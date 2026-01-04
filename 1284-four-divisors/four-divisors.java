class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int s=0;int c=0;
            for(int j=1;j<=nums[i];j++){
                if(nums[i]%j==0){
                    c++;
                    s+=j;
                    if(c>4){
                        break;
                    }
                }
            }
            if(c<4||c>4){
                s=0;
            }
            sum+=s;
        }
        return sum;
    }
}
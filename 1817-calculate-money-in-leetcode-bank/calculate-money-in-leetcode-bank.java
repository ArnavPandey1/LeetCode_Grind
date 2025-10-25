class Solution {
    public int totalMoney(int n) {
        int w=n/7;
        int d=n%7;
        int sum=0;
        for(int i=1;i<=w;i++){
            sum=sum+7*(3+i);
        }
        int startVal=w+1;
        for(int i=1;i<=d;i++){
            sum=sum+(startVal++);
        }
        return sum;
    }
}
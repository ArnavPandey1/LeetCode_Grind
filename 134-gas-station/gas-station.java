class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasHave=0;
        int gasReq=0;int currg=0;int start=0;
        for(int i=0;i<gas.length;i++){
            gasHave+=gas[i];
            gasReq+=cost[i];
           currg=currg+gas[i]-cost[i];
           if(currg<0){
            start=i+1;
            currg=0;
           }
        }
        if(gasHave<gasReq)
        return -1;
        return start;
    }
}
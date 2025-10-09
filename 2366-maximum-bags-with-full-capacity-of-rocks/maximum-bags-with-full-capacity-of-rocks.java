class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int arr[][]=new int[capacity.length][2];
        for(int i=0;i<capacity.length;i++){
            capacity[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(capacity);
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(capacity[i]==0||capacity[i]<=additionalRocks){
                additionalRocks-=capacity[i];
                c++;
            }
            else{
                break;
            }
        }
        return c;
    }
}
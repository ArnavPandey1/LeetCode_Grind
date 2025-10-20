class Solution {
    public int finalValueAfterOperations(String[] arr) {
        int val=0;
        for(int i=0;i<arr.length;i++){
            String s=arr[i];
            if(s.equals("--X")||s.equals("X--")){
                val=val-1;
            }
            else{
                val=val+1;
            }
        }
        return val;
    }
}
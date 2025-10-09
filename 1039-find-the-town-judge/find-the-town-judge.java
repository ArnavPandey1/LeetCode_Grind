class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[][]=new int[n][n];
        for(int i=0;i<trust.length;i++){
                  arr[trust[i][0]-1][trust[i][1]-1]=1;
        }
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }
        while(st.size()>=2){
            int b=st.pop();
            int a=st.pop();
            if(arr[a][b]==1)
            st.push(b);
            else
            st.push(a);
        }
        for(int i=0;i<n;i++){
            if(i!=st.peek()&&(arr[st.peek()][i]==1||arr[i][st.peek()]==0))
            return -1;
        }
        return st.pop()+1;
    }
}
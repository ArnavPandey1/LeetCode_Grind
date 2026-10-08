class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int[26];int k=0;
        for(int i=0;i<tasks.length;i++){
            char ch=tasks[i];
            freq[ch-'A']++;
        }
        int c=tasks.length;
        Arrays.sort(freq);
        int gaddhe=freq[freq.length-1]-1;
        int slots=gaddhe*n;
        for(int i=freq.length-2;i>=0;i--){
            if(freq[i]==0)break;
            slots=slots-Math.min(gaddhe,freq[i]);
            if(slots<=0)return c;
        }
         
         return c+slots;
    }
}
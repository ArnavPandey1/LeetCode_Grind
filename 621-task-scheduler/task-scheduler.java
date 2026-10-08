class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            char ch=tasks[i];
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }int c=0;
        int freq[]=new int[map.size()];int k=0;
        for(char ch:map.keySet()){
            freq[k++]=map.get(ch);
            c+=map.get(ch);
        }
        Arrays.sort(freq);
        int gaddhe=freq[freq.length-1]-1;
        int slots=gaddhe*n;
        for(int i=freq.length-2;i>=0;i--){
            slots=slots-Math.min(gaddhe,freq[i]);
            if(slots<=0)return c;
        }
         
         return c+slots;
    }
}
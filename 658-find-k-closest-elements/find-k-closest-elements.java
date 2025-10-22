class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            if(Math.abs(a-x)==Math.abs(b-x))
            return a-b;
            return Integer.compare(Math.abs(a-x),Math.abs(b-x));
        });
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        List<Integer>l1=new ArrayList<>();
        while(!pq.isEmpty()&&k-->0){
            l1.add(pq.remove());
        }
        Collections.sort(l1);
        return l1;
    }
}
class Solution {
    class Pair {
        String s;
        int val;

        Pair(String s, int val) {
            this.s = s;
            this.val = val;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.val == b.val) {
                return a.s.compareTo(b.s);
            } else {
                return b.val - a.val;
            }
        });
        for(String str:map.keySet()){
            pq.add(new Pair(str,map.get(str)));
        }
        List<String>l1=new ArrayList<>();
        while(k>0){
            l1.add(pq.remove().s);
            k--;
        }       
        return l1;   
    }
}
class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)
        return word;
        int n=word.length();
        PriorityQueue<String>pq=new PriorityQueue<>((a,b)->b.compareTo(a));
        int maxTake=n-(numFriends-1);
        for(int i=0;i<word.length();i++){
            int canTake=Math.min(maxTake,n-i);
            pq.add(word.substring(i,i+canTake));
        }
        return pq.remove();
    }
}
class Solution {
    class Pair{
        long endTime;
        long roomNo;
        Pair(long endTime,long roomNo){
            this.endTime=endTime;
            this.roomNo=roomNo;
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        long meetingCount[]=new long[n];
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Long>availableRoom=new PriorityQueue<>();
        PriorityQueue<Pair>usedRoom=new PriorityQueue<>((a,b)->{
             if(a.endTime!=b.endTime){
                return Long.compare(a.endTime,b.endTime);
             }
             return Long.compare(a.roomNo,b.roomNo);
        });
         for(int i=0;i<n;i++){
             availableRoom.add((long)i);
         }  
        for(int i=0;i<meetings.length;i++){
            long st=meetings[i][0];
            long end=meetings[i][1];
            long duration=end-st;
            
            //make available room;
            while(!usedRoom.isEmpty()&&st>=usedRoom.peek().endTime){
                 long room=usedRoom.peek().roomNo;
                 usedRoom.poll();
                 availableRoom.add(room);
            }
            if(!availableRoom.isEmpty()){
               long r=availableRoom.poll();
               usedRoom.add(new Pair(end,r));
               meetingCount[(int)r]++;
            }else{
               long r=usedRoom.peek().roomNo;
               long e=usedRoom.peek().endTime;
               usedRoom.poll();
               usedRoom.add(new Pair(e+duration,r));
               meetingCount[(int)r]++;
            }

        }
         long count=0;int result=0;
         for(int i=0;i<meetingCount.length;i++){
            if(meetingCount[i]>count){
                count=meetingCount[i];
                result=i;
            }
         }
         return result;
    }
}
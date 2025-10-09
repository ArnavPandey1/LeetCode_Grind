class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long lb=time[0];
        long ub=(long)time[time.length-1]*totalTrips;
        long ans=-1;
        while(lb<=ub){
            long mid=(lb+(ub-lb)/2);
            long trips_made=find(time,mid);
            if(trips_made>=totalTrips){
                ans=mid;
                ub=mid-1;
            }
            else{
                lb=mid+1;
            }
        }
        return ans;
    }
    public long find(int time[],long mid){
        long total_trip=0;
        for(int i=0;i<time.length;i++){
            total_trip+=mid/time[i];
        }
        return total_trip;
    }
}
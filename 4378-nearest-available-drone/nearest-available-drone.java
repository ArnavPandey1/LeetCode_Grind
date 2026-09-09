class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int idx=-1;
        int min=Integer.MAX_VALUE;
        int tx=target[0];int ty=target[1];
        for(int i=0;i<drones.length;i++){
            int dx=drones[i][0];
            int dy=drones[i][1];
            int range=drones[i][2];
            int dis=Math.abs(dx-tx)+Math.abs(dy-ty);
            if(dis<=range){
                if(dis<min){
                   min=dis;
                   idx=i;
                }
            }
        }
        return idx;
    }
}
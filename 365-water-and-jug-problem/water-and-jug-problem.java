class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        Set<String>set=new HashSet<>();
        return traverse(0,0,target,x,y,set);
    }
    public boolean traverse(int  x,int  y,int target,int xl,int yl,Set<String>set){
        if(x==target || y==target || x+y==target){
            return true;
        }
        if(set.contains(x+","+y))return false;
        set.add(x+","+y);
        return traverse(xl,y,target,xl,yl,set)||
        traverse(x,yl,target,xl,yl,set)||
        traverse(0,y,target,xl,yl,set)||
        traverse(x,0,target,xl,yl,set)||
        traverse(x+Math.min(y,xl-x),y-Math.min(y,(xl-x)),target,xl,yl,set)||
        traverse(x-Math.min(x,(yl-y)),y+Math.min(x,yl-y),target,xl,yl,set);
    }
}
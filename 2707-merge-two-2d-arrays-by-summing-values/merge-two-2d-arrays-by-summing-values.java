class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int []>l1=new ArrayList<>();
        Arrays.sort(nums1,(a,b)->a[0]-b[0]);
        Arrays.sort(nums2,(a,b)->a[0]-b[0]);
        int i=0;int j=0;
        while(i<nums1.length&&j<nums2.length){
             if(nums1[i][0]==nums2[j][0]){
                l1.add(new int[]{nums1[i][0],nums1[i][1]+nums2[j][1]});
                i++;
                j++;
            }else if(nums1[i][0]<nums2[j][0]){
                l1.add(nums1[i]);
                i++;
            }else{
                l1.add(nums2[j]);
                j++;
            }
        }
        while(i<nums1.length){
            l1.add(nums1[i]);
            i++;
        }
        while(j<nums2.length){
            l1.add(nums2[j]);
            j++;
        }
        int ans[][]=new int[l1.size()][2];
        for(int k=0;k<l1.size();k++){
            ans[k]=l1.get(k);
        }
        return ans;
    }
}
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] nums1, int[][] nums2) {
         List<List<Integer>>l1=new ArrayList<>();
        Arrays.sort(nums1,(a,b)->a[0]-b[0]);
        Arrays.sort(nums2,(a,b)->a[0]-b[0]);
        int i=0;int j=0;
        while(i<nums1.length&&j<nums2.length){
             if(nums1[i][0]==nums2[j][0]){   
              l1.add(Arrays.asList(nums1[i][0], nums1[i][1] + nums2[j][1]));
                i++;
                j++;
            }else if(nums1[i][0]<nums2[j][0]){
                l1.add(Arrays.asList(nums1[i][0],nums1[i][1]));
                i++;
            }else{
                l1.add(Arrays.asList(nums2[j][0],nums2[j][1]));
                j++;
            }
        }
        while(i<nums1.length){
            l1.add(Arrays.asList(nums1[i][0],nums1[i][1]));
            i++;
        }
        while(j<nums2.length){
            l1.add(Arrays.asList(nums2[j][0],nums2[j][1]));
            j++;
        }
        
        return l1;
    }
}
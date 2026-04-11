class Solution {
    public int minimumDistance(int[] nums) {
        // Map to store the last two indices seen for each number
        // indexMap.get(val)[0] = index of the occurrence before last
        // indexMap.get(val)[1] = index of the most recent occurrence
        Map<Integer, int[]> indexMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            
            if (!indexMap.containsKey(val)) {
                // First time seeing this number: store -1 as a placeholder
                indexMap.put(val, new int[]{-1, i});
            } else {
                int[] lastIndices = indexMap.get(val);
                
                // If we have at least two previous indices, we can form a triplet
                if (lastIndices[0] != -1) {
                    int firstIdx = lastIndices[0];
                    int currentIdx = i;
                    // Distance is 2 * (max_idx - min_idx)
                    minDistance = Math.min(minDistance, 2 * (currentIdx - firstIdx));
                    found = true;
                }
                
                // Shift indices: the old "last" becomes the "second to last"
                lastIndices[0] = lastIndices[1];
                lastIndices[1] = i;
            }
        }

        return found ? minDistance : -1;
    }
}
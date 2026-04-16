import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        // Step 1: Group all indices for each unique number
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int qIdx : queries) {
            int targetVal = nums[qIdx];
            List<Integer> indices = indexMap.get(targetVal);
    if (indices.size() <= 1) {
                result.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(indices, qIdx);
            
            int minDict = Integer.MAX_VALUE;
            int size = indices.size();
            int[] neighbors = {
                (pos - 1 + size) % size, // Neighbor to the left
                (pos + 1) % size         // Neighbor to the right
            };

            for (int neighborIdx : neighbors) {
                int otherIdx = indices.get(neighborIdx);
                int diff = Math.abs(qIdx - otherIdx);
                // Standard circular distance formula
                int dist = Math.min(diff, n - diff);
                minDict = Math.min(minDict, dist);
            }

            result.add(minDict);
        }

        return result;
    }
}
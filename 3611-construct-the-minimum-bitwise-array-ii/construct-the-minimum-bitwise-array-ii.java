class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            // Case nums[i] == 2
            if (nums.get(i) == 2) {
                result[i] = -1;
                continue;
            }

            boolean found = false;
            int val = nums.get(i);

            // check bits from 1 to 31
            for (int j = 1; j < 32; j++) {

                // if j-th bit is set, skip
                if ((val & (1 << j)) != 0) {
                    continue;
                }

                // j-th bit is 0 → flip (j-1)-th bit
                int x = val ^ (1 << (j - 1));
                result[i] = x;
                found = true;
                break;
            }

            // safety (should not happen for valid primes except 2)
            if (!found) {
                result[i] = -1;
            }
        }

        return result;
    }
}

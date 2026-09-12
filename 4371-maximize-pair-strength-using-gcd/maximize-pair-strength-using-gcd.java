class Solution {
    public long maxPairStrength(int[] nums) {
        long ans=Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j =i+1; j < nums.length; j++) {
                long a = nums[i];
                long b = nums[j];
                long c = gcd(a, b);
                ans = Math.max(ans,(a * b) / (c * c));
            }
        }
        return ans;
    }

    public static long gcd(long a, long b) {
        while (b > 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
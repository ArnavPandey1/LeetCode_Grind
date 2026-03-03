class Solution {
    public char findKthBit(int n, int k) {
        String ar[] = new String[n + 1];
        ar[1] = "0";
        for (int i = 2; i < ar.length; i++) {
            String s = ar[i - 1];
            StringBuilder sb = new StringBuilder(s.length());

            for (int j = s.length() - 1; j >= 0; j--) {
                sb.append(s.charAt(j) == '0' ? '1' : '0');
            }

            String s1 = sb.toString();
            ar[i] = s + '1' + s1;
        }
        return ar[ar.length - 1].charAt(k - 1);
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq1[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
        }
        int i = 0;
        int j = 0;
        int freq2[] = new int[26];
        while (j < s2.length()) {
            char ch = s2.charAt(j);
            freq2[ch - 'a']++;
            while(j-i+1>s1.length()){
                 freq2[s2.charAt(i)-'a']--;
                 i++;
            }
            if(Arrays.equals(freq1,freq2))
            return true;
            j++;
        }
        return false;
    }
}
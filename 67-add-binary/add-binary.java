class Solution {
    public String addBinary(String a, String b) {
        int c = 0;
        String ans = "";
        int j = b.length() - 1;
        int i = a.length() - 1;
        while (i >= 0 && j >= 0) {
            char ch1 = a.charAt(i);
            char ch2 = b.charAt(j);
            if (c == 0) {
                if (ch1 == '1' && ch2 == '0') {
                    ans = '1' + ans;
                    c = 0;
                }
                if (ch1 == '0' && ch2 == '1') {
                    ans = '1' + ans;
                    c = 0;
                }
                if (ch1 == '1' && ch2 == '1') {
                    ans = '0' + ans;
                    c = 1;
                }
                if (ch1 == '0' && ch2 == '0') {
                    ans = '0' + ans;
                    c = 0;
                }
            } else {
                if (ch1 == '1' && ch2 == '0') {
                    ans = '0' + ans;
                    c = 1;
                }
                if (ch1 == '0' && ch2 == '1') {
                    ans = '0' + ans;
                    c = 1;
                }
                if (ch1 == '1' && ch2 == '1') {
                    ans = '1' + ans;
                    c = 1;
                }
                if (ch1 == '0' && ch2 == '0') {
                    ans = '1' + ans;
                    c = 0;
                }
            }
            i--;
            j--;
        }
        while (i >= 0) {
            char ch1 = a.charAt(i);
            if (c == 0) {
                if (ch1 == '1') {
                    ans = '1' + ans;
                    c = 0;
                }
                if (ch1 == '0') {
                    ans = '0' + ans;
                    c = 0;
                }
            } else {
                if (ch1 == '1') {
                    ans = '0' + ans;
                    c = 1;
                }
                if (ch1 == '0') {
                    ans = '1' + ans;
                    c = 0;
                }
            }
            i--;
        }
        while (j >= 0) {
            char ch1 = b.charAt(j);
            if (c == 0) {
                if (ch1 == '1') {
                    ans = '1' + ans;
                    c = 0;
                }
                if (ch1 == '0') {
                    ans = '0' + ans;
                    c = 0;
                }
            } else {
                if (ch1 == '1') {
                    ans = '0' + ans;
                    c = 1;
                }
                if (ch1 == '0') {
                    ans = '1' + ans;
                    c = 0;
                }
            }
            j--;
        }
        if (c == 1)
            ans = '1' + ans;
        return ans;
    }
}
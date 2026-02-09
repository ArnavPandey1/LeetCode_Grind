class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int arr[] = new int[queries.length];
        int k = 0;
        for (int i[] : queries) {
            int a = i[0];
            int b = i[1];
            int c = 0;
            while (a != b) {
                if (a > b) {
                    a = a / 2;
                } else {
                    b = b / 2;
                }
                c++;
            }
            arr[k++] = c + 1;
        }
        return arr;
    }
}
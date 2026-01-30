class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int ans[] = new int[deck.length];
        Arrays.sort(deck);
        int n = deck.length;
        int i = 0;
        int j = 0;
        int c = 1;
        while (i < n) {
            if (ans[j] == 0) {
                if (c % 2 != 0) {
                   ans[j]=deck[i];
                   i++;
                   c++;
                } else {
                   c++;
                }
            }
            j = (j + 1) % n;
        }
        return ans;
    }
}
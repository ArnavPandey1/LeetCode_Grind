class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int lb = 0;
        int ub = people.length - 1;
        int c = 0;
        while (lb <= ub) {
            if (people[lb] + people[ub] > limit) {
                if(people[lb]>people[ub])lb++;
                else ub--;
            } else {
                lb++;
                ub--;
            }
            c++;
        }
        return c;
    }
}
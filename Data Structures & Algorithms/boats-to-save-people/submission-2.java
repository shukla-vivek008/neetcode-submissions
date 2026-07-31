class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);
        int p1 = 0;
        int p2 = people.length - 1;

        while (p1 <= p2) {
            if (people[p1] + people[p2] <= limit) {
                p1++;
            }
            boat++;
            p2--;
        }

        return boat;
    }
}
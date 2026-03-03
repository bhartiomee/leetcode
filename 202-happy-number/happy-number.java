class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> vis = new HashSet<>();

        while (!vis.contains(n)) {
            vis.add(n);
            n = getNext(n);
            if (n == 1)
                return true;
        }
        return false;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {

            int d = n % 10;
            sum += d * d;
            n /= 10;

        }
        return sum;
    }
}
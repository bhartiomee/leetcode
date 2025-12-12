class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dd = new HashSet<>(Arrays.asList(deadends));
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        String start = "0000";

        if (target.equals(start))
            return 0;
        if (dd.contains(target)||dd.contains(start))
            return -1;
        q.offer(new Pair<>(start, 0));
        vis.add(start);

        while (!q.isEmpty()) {
            Pair<String, Integer> node = q.poll();
            String currComb = node.getKey();
            int moves = node.getValue();

            if (currComb.equals(target))
                return moves;

            for (int i = 0; i < 4; i++) {
                for (int delta : new int[] { -1, 1 }) {
                    int newDig = (currComb.charAt(i) - '0' + delta + 10) % 10;
                    String newComb = currComb.substring(0, i) 
                                    + newDig + currComb.substring(i + 1);

                    if (!vis.contains(newComb) && !dd.contains(newComb)) {
                        vis.add(newComb);
                        q.offer(new Pair<>(newComb, moves + 1));
                    }
                }
            }

           

        }
         return -1;

    }
}
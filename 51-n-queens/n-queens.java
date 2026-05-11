class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] ch = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(ch[i], '.');
        }
        helper(n, 0, ch);
        return ans;
    }

    public void helper(int n, int i, char[][] ch) {
        if (i == n) {
            List<String> temp = new ArrayList<>();

            for (int r = 0; r < n; r++) {
                temp.add(new String(ch[r]));
            }
            ans.add(temp);
            return;
        }

        if (i > n)
            return;

        for (int col = 0; col < n; col++) {
            if (isValid(i, col, ch, n)) {
                ch[i][col] = 'Q';
                helper(n, i + 1, ch);
                ch[i][col] = '.';
            }
        }
    }

    public boolean isValid(int row, int col, char[][] ch, int n) {

        for (int i = 0; i < row; i++) {
            if (ch[i][col] == 'Q')
                return false;
        }


        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (ch[r][c] == 'Q')
                return false;
            r--;
            c--;
        }

        r = row;
        c = col;
        while (r >= 0 && c < n) {
            if (ch[r][c] == 'Q')
                return false;
            r--;
            c++;
        }

        return true;

    }

}
class NumMatrix {
    private int[][] pref;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        pref = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[i + 1][j + 1] = matrix[i][j] 
                                  + pref[i][j + 1] 
                                  + pref[i + 1][j] 
                                  - pref[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pref[row2 + 1][col2 + 1] 
             - pref[row1][col2 + 1] 
             - pref[row2 + 1][col1] 
             + pref[row1][col1];
    }
}
class Solution {
    
    public void solveSudoku(char[][] board) 
    {
        int[] rows=new int[10];
        int[] cols=new int[10];
        int[][] mat=new int[3][3];
        ArrayList<Integer> cells=new ArrayList<>();
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                int num=board[i][j]-'0';//necessary to convert to integer value, otherwise gives out of bounds error
                if (board[i][j] == '.')
                {
                    cells.add(i * 9 + j);
                }
                else
                {
                    int mask=(1<<num);
                    rows[i]^=mask;
                    cols[j]^=mask;
                    mat[i/3][j/3]^=mask;
                }
            }
        }

        solveSudoku(board, 0, cells,rows,cols,mat);
    }
    
    public boolean solveSudoku(char[][] board, int idx, ArrayList<Integer> cells,int[] rows,int[] cols,int[][] mat)
    {
        if (idx == cells.size())
            return true;

        int r = cells.get(idx) / 9, c = cells.get(idx) % 9;
        for (int num = 1; num <= 9; num++)
        {
            int mask=(1<<num);
            if ((rows[r]&mask)==0 && (cols[c]&mask)==0 && (mat[r/3][c/3]&mask)==0)
            {
                rows[r]^=mask;
                    cols[c]^=mask;
                    mat[r/3][c/3]^=mask;
                board[r][c] = (char)('0' + num);
                if (solveSudoku(board, idx + 1, cells,rows,cols,mat))
                    return true;
                rows[r]^=mask;
                    cols[c]^=mask;
                    mat[r/3][c/3]^=mask;
                board[r][c] = '.';
            }
        }

        return false;
    }
    
}

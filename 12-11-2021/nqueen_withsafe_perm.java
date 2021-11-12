import java.util.*;

public class Main
{

    public static boolean isSafe(boolean[][] board, int sr, int sc)
    {
        int n=board.length, m=board[0].length;
        //now since it is permutation, we have to check in all 8 directions
        int[][] dir={{0,-1},{-1,0},{-1,-1},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        for(int[] d:dir)
        {
            int r=sr;
            int c=sc;
            while(r>=0 && c>=0 && r<n && c<m)
            {
                if(board[r][c])
                {
                    return false;
                }
                r+=d[0];
                c+=d[1];
            }
        }
        return true;
    }
    //nq=total number of queens
    //asf=answer so far
    public static int nqueensafeuo(boolean[][] board, int idx, int nq, String asf)
    {
        if (nq==0)
        {
            //System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n=board.length, m=board[0].length;
        for (int i = idx; i < n*m; i++)
        {
            //we take the 2d array in the form of multiple 1d arrays, and to find the row number and column number, we apply this formula.
            int r=i/m, c=i%m;
            if(isSafe(board,r,c))
            {
                board[r][c]=!board[r][c];
                count += nqueensafeuo(board, 0, nq-1, asf + "(" + r + "," + c + ") ");
                board[r][c]=!board[r][c];
            }
            
        }

        return count;
    }

    public static void main(String[] args)
    {
        int n=4,nq=4;
        boolean[][] board=new boolean[n][n];
        System.out.println(nqueensafeuo(board,0,nq,""));
    }

}
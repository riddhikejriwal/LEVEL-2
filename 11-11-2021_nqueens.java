import java.util.*;

public class nqueen2d_perm
{
    //nq=total number of queens
    //asf=answer so far
    public static int nqueen2dperm(boolean[][] board, int idx, int nq, String asf)
    {
        if (nq==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n=board.length, m=board[0].length;
        for (int i = idx; i < n*m; i++)
        {
            //we take the 2d array in the form of multiple 1d arrays, and to find the row number and column number, we apply this formula.
            int r=i/m, c=i%m;
            if(!board[r][c])
            {
                board[r][c]=!board[r][c];
                count += nqueen2dperm(board, 0, nq-1, asf + "(" + r + "," + c + ") ");
                board[r][c]=!board[r][c];
            }
            
        }

        return count;
    }
    public static void main(String[] args)
    {
        int n=4,nq=4;
        boolean[][] board=new boolean[n][n];

        System.out.println(nqueen2dperm(board,0,nq,""));
    }
}

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class nqueen1d_comb
{
    //nq=total number of queens
    //qpsf=queen placed so far
    //asf=answer so far
    public static int nqueen1dcomb(boolean[] board, int idx, int nq, int qpsf, String asf)
    {
        if (qpsf == nq)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < board.length; i++)
        {
            count += nqueen1dcomb(board, i + 1, nq, qpsf + 1, asf + "b" + i + "q" + qpsf + " ");
        }

        return count;
    }
    public static void main(String[] args)
    {
        int n=5,nq=3;
        boolean[] board=new boolean[n];
        Arrays.fill(board, false);

        System.out.println(nqueen1dcomb(board,0,nq,0,""));
    }
}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class nqueen1d_comb_ss
{
    //nq=total number of queens
    //qpsf=queen placed so far
    //asf=answer so far
    public static int nqueen1dcomb_ss(boolean[] board, int idx, int nq, int qpsf, String asf)
    {
        if (qpsf == nq || idx==board.length)
        {
            if(qpsf==nq)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += nqueen1dcomb_ss(board, idx + 1, nq, qpsf + 1, asf + "b" + idx + "q" + qpsf + " ");
        count += nqueen1dcomb_ss(board, idx + 1, nq, qpsf, asf);

        return count;
    }
    public static void main(String[] args)
    {
        int n=5,nq=3;
        boolean[] board=new boolean[n];
        Arrays.fill(board, false);

        System.out.println(nqueen1dcomb_ss(board,0,nq,0,""));
    }
}

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class nqueen1d_perm
{
    //nq=total number of queens
    //qpsf=queen placed so far
    //asf=answer so far
    public static int nqueen1dperm(boolean[] board, int idx, int nq, int qpsf, String asf)
    {
        if (qpsf == nq)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < board.length; i++)
        {
            if(!board[i])
            {
                board[i]=!board[i];
                count += nqueen1dperm(board, 0, nq, qpsf + 1, asf + "b" + i + "q" + qpsf + " ");
                board[i]=!board[i];
            }
        }

        return count;
    }
    public static void main(String[] args)
    {
        int n=5,nq=3;
        boolean[] board=new boolean[n];
        Arrays.fill(board, false);

        System.out.println(nqueen1dperm(board,0,nq,0,""));
    }
}

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class nqueen1d_perm_ss
{
    //nq=total number of queens
    //qpsf=queen placed so far
    //asf=answer so far
    public static int nqueen1dperm_ss(boolean[] board, int idx, int nq, int qpsf, String asf)
    {
        if (qpsf == nq || idx==board.length)
        {
            if(qpsf==nq)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(!board[idx])
        {
            board[idx]=!board[idx];
            count += nqueen1dperm_ss(board, 0, nq, qpsf + 1, asf + "b" + idx + "q" + qpsf + " ");
            board[idx]=!board[idx];
        }
        count += nqueen1dperm_ss(board,idx+1, nq, qpsf,asf);

        return count;
    }
    public static void main(String[] args)
    {
        int n=5,nq=3;
        boolean[] board=new boolean[n];
        Arrays.fill(board, false);

        System.out.println(nqueen1dperm_ss(board,0,nq,0,""));
    }
}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class nqueen2d_comb
{
    //nq=total number of queens
    //asf=answer so far
    public static int nqueen2dcomb(boolean[][] board, int idx, int nq, String asf)
    {
        if (nq==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n=board.length, m=board[0].length;
        for (int i = idx; i < n*m; i++)
        {
            //we take the 2d array in the form of multiple 1d arrays, and to find the row number and column number, we apply this formula.
            int r=i/m, c=i%m;
            count += nqueen2dcomb(board, i + 1, nq-1, asf + "(" + r + "," + c + ") ");
        }

        return count;
    }
    public static void main(String[] args)
    {
        int n=4,nq=4;
        boolean[][] board=new boolean[n][n];

        System.out.println(nqueen2dcomb(board,0,nq,""));
    }

}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class nqueen2d_comb_ss
{
    //nq=total number of queens
    //asf=answer so far
    public static int nqueen2dcomb_ss(boolean[][] board, int idx, int nq, String asf)
    {
        int n=board.length, m=board[0].length;
        if (nq==0 || idx==n*m)
        {
            if(nq==0)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        
        //we take the 2d array in the form of multiple 1d arrays, and to find the row number and column number, we apply this formula.
        int r=idx/m, c=idx%m;
        count += nqueen2dcomb_ss(board, idx + 1, nq-1, asf + "(" + r + "," + c + ") ");
        count += nqueen2dcomb_ss(board, idx + 1, nq, asf);

        return count;
    }
    public static void main(String[] args)
    {
        int n=4,nq=4;
        boolean[][] board=new boolean[n][n];

        System.out.println(nqueen2dcomb_ss(board,0,nq,""));
    }
}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class nqueen2d_perm_ss
{
    //nq=total number of queens
    //asf=answer so far
    public static int nqueen2dperm_ss(boolean[][] board, int idx, int nq, String asf)
    {
        int n=board.length, m=board[0].length;
        if (nq==0 || idx==n*m)
        {
            if(nq==0)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        //we take the 2d array in the form of multiple 1d arrays, and to find the row number and column number, we apply this formula.
        int r=idx/m, c=idx%m;
        if(!board[r][c])
        {
            board[r][c]=!board[r][c];
            count += nqueen2dperm_ss(board, 0, nq-1, asf + "(" + r + "," + c + ") ");
            board[r][c]=!board[r][c];
        }
        count += nqueen2dperm_ss(board, idx+1, nq, asf);

        return count;
    }
    public static void main(String[] args)
    {
        int n=4,nq=4;
        boolean[][] board=new boolean[n][n];

        System.out.println(nqueen2dperm_ss(board,0,nq,""));
    }
}

import java.util.*;

public class nqueen_safeperm
{
    
    //nq=total number of queens
    //asf=answer so far
    public static int nqueensafeperm(int n, int m , int idx, int nq, String asf,boolean[] rows, boolean[] cols, boolean[] diag, boolean[] adiag)
    {
        if (nq==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < n*m; i++)
        {
            //we take the 2d array in the form of multiple 1d arrays, and to find the row number and column number, we apply this formula.
            int r=i/m, c=i%m;
            if(!rows[r] && !cols[c] && !diag[r+c] && !adiag[r-c+m-1])
            {
                rows[r]=cols[c]=diag[r+c]=adiag[r-c+m-1]=true;
                count+=nqueensafeperm(n,m,0,nq-1,asf+"("+r+","+c+") ",rows,cols,diag,adiag);
                rows[r]=cols[c]=diag[r+c]=adiag[r-c+m-1]=false;
            }
            
        }

        return count;
    }

    public static void main(String[] args)
    {
        int n=4,nq=4;
        boolean[] rows=new boolean[n];
        boolean[] cols=new boolean[n];
        boolean[] diag=new boolean[2*n-1];
        boolean[] adiag=new boolean[2*n-1];
        System.out.println(nqueensafeperm(n,n,0,nq,"",rows,cols,diag,adiag));
    }

}
class nqueens_optimised {
    public sttaic void main(String[] args) {
        boolean[] cols=new boolean[n];
        boolean[] diag=new boolean[2*n-1];
        boolean[] adiag=new boolean[2*n-1];
        System.out.println(nqueensafe(n,n,0,n,cols,diag,adiag));
    }
    
    public static int nqueensafe(int n, int m , int floor, int nq, boolean[] cols, boolean[] diag, boolean[] adiag)
    {
        if (nq==0)
        {
            return 1;
        }

        int count = 0;
        for (int rooms = 0; rooms < m; rooms++)
        {
            //we take the 2d array in the form of multiple 1d arrays, and to find the row number and column number, we apply this formula.
            int r=floor, c=rooms;
            if(!cols[c] && !diag[r+c] && !adiag[r-c+m-1])
            {
                cols[c]=diag[r+c]=adiag[r-c+m-1]=true;
                count+=nqueensafe(n,m,floor+1,nq-1,cols,diag,adiag);
                cols[c]=diag[r+c]=adiag[r-c+m-1]=false;
            }
            
        }

        return count;
    }
}
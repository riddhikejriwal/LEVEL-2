import java.util.*;

public class floodfill_count
{
    public static int floodfill1(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String dirS[], String psf)
    {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c])
                count += floodfill1(r, c, er, ec, vis, dir, dirS, psf + dirS[d]);
        }
        vis[sr][sc] = false;
        return count;
    }
    public static void main(String[] args){
        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        String[] dirS = { "u", "e", "r", "n", "d", "w", "l", "s" };
        boolean[][] vis=new boolean[3][3];
        System.out.println(floodfill1(0,0,2,2,vis,dir,dirS,""));
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class floodfill_jumps
{
    //this method takes too much time as it will make us visit the invalid points again and agin for all radii, even though it is not needed, and will just end up taking a lot of time.
    public static int floodfill4_01(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String dirS[], String psf)
    {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;
        for (int rad = 1; rad <= Math.max(er, ec); rad++)
            for (int d = 0; d < dir.length; d++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c])
                    count += floodfill4_01(r, c, er, ec, vis, dir, dirS, psf + rad + dirS[d]);
            }
        vis[sr][sc] = false;
        return count;
    }

    //this method is not "good-looking"
    public static int floodfill4_02(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String[] dirS, String psf) 
    {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;
        for (int d = 0; d < dir.length; d++)
            for (int rad = 1; rad <= Math.max(er, ec); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    if (!vis[r][c])
                        count += floodfill4_02(r, c, er, ec, vis, dir, dirS, psf + rad + dirS[d]);
                } 
                else
                    break;
            }
        vis[sr][sc] = false;
        return count;
    }

    //this method is optimal and better looking
    public static int floodfill4_03(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String[] dirS, String psf) 
    {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            int rad = 1;
            while (r >= 0 && c >= 0 && r <= er && c <= ec) {
                if (!vis[r][c])
                {
                    count += floodfill4_03(r, c, er, ec, vis, dir, dirS, psf + rad + dirS[d]);
                }  
                r += dir[d][0];
                c += dir[d][1];
                rad++;
            }
        }
        vis[sr][sc] = false;
        return count;
    }
    
    public static void main(String[] args){
        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        String[] dirS = { "u", "e", "r", "n", "d", "w", "l", "s" };
        boolean[][] vis=new boolean[3][3];
        //System.out.println(floodfill4_01(0,0,2,2,vis,dir,dirS,""));
        //System.out.println(floodfill4_02(0,0,2,2,vis,dir,dirS,""));
        System.out.println(floodfill4_03(0,0,2,2,vis,dir,dirS,""));
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class floodfill_lspath
{
    public static class floodfillPair
    {
        String lpath="";
        String spath="";
        int lLen=0;
        int sLen=(int)1e9;
        boolean isPathFound=false;
    }
    public static floodfillPair floodfill3(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String dirS[])
    {
        if (sr == er && sc == ec) {
            floodfillPair base=new floodfillPair();
            base.isPathFound=true;
            base.sLen=0;
            return base;
        }

        vis[sr][sc] = true;
        floodfillPair ans=new floodfillPair();
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c])
            {
                floodfillPair recRes=floodfill3(r,c,er,ec,vis,dir,dirS);
                if(recRes.isPathFound)
                {
                    ans.isPathFound=true;
                    if(recRes.lLen+1>ans.lLen)
                    {
                        ans.lLen=recRes.lLen+1;
                        ans.lpath=dirS[d]+recRes.lpath;
                    }
                    if(recRes.sLen+1<ans.sLen)
                    {
                        ans.sLen=recRes.sLen+1;
                        ans.spath=dirS[d]+recRes.spath;
                    }
                }
            }
        }
        vis[sr][sc] = false;
        return ans;
    }
    public static void main(String[] args){
        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        String[] dirS = { "u", "e", "r", "n", "d", "w", "l", "s" };
        boolean[][] vis=new boolean[3][3];
        floodfillPair ff=floodfill3(0,0,2,2,vis,dir,dirS);
        System.out.println("Longest-->"+ff.lpath+"@"+ff.lLen);
        System.out.println("Shortest-->"+ff.spath+"@"+ff.sLen);
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class floodfill_singlepath
{
    public static boolean floodfill2(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String dirS[], String psf)
    {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return true;
        }

        vis[sr][sc] = true;
        boolean res=false;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c])
                res = res || floodfill2(r, c, er, ec, vis, dir, dirS, psf + dirS[d]);//res remains false till you dont get a path, and waits for the answer from the function call. As soon as you receive a path, res becomes true, and then, it will not wait for the answer from function call.
        }
        vis[sr][sc] = false;
        return res;
    }
    public static void main(String[] args){
        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        String[] dirS = { "u", "e", "r", "n", "d", "w", "l", "s" };
        boolean[][] vis=new boolean[3][3];
        System.out.println(floodfill2(0,0,2,2,vis,dir,dirS,""));
    }
}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class knightstour_dirArr
{
    public static boolean knightTour(int sr, int sc, int[][] board, int[][] dir, int count) {

        int n = board.length;
        int m = board[0].length;
        board[sr][sc] = count;
        if (count == n * m) {
            return true;
        }

        boolean res = false;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 0)
                res = res || knightTour(r, c, board, dir, count + 1);

        }
        if (!res)
            board[sr][sc] = 0;
        return res;
    }
    public static void main(String[] args){
        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        int[][] board=new int[3][3];
        System.out.println(knightTour(0,0,board,dir,0));
    }
}

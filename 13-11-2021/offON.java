import java.util.*;

public class offON
{
    public static int offON(int x, int k)
    {
        int mask=(1<<k);
        return x|=mask;
    }

    public static void main(String[] args)
    {
        int x=8;
        int k=2;
        System.out.print(offON(x,k));
    }
}

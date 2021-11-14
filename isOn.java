import java.util.*;

public class isOn
{
    public static boolean isOn(int x, int k)
    {
        int mask=(1<<k);
        return (x & mask)!=0;
    }

    public static void main(String[] args)
    {
        int x=8;
        int k=2;
        System.out.print(isOn(x,k));
    }
}
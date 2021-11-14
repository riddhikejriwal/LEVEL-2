import java.util.*;

public class onOFF
{
    public static int onOFF(int x, int k)
    {
        int mask=(~(1<<k));
        return x&=mask;
    }

    public static void main(String[] args)
    {
        int x=8;
        int k=2;
        System.out.print(onOFF(x,k));
    }
}
import java.util.*;

public class cc_infinitecombinations
{
    public static int cc_infcom(int[] arr, int idx, int tar, String psf)
    {
        if(tar==0)
        {
            System.out.println(psf);
            return 1;
        }
        int count=0;
        for(int i=idx;i<arr.length;i++)
        {
            if(tar-arr[i]>=0)
            {
                count+=cc_infcom(arr,i,tar-arr[i],psf+arr[i]);
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        int[] arr={2,3,5,7};
        int tar=10;
        System.out.println(cc_infcom(arr,0,tar,""));
    }
}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
  import java.util.*;

public class cc_infinitecombinations_ss
{
    public static int cc_infcom_ss(int[] arr, int idx, int tar, String psf)
    {
        if(tar==0 || idx==arr.length)
        {
            if(tar==0)
            {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
        int count=0;
        if(tar-arr[idx]>=0)
        {
            count+=cc_infcom_ss(arr,idx,tar-arr[idx],psf+arr[idx]);
        }
        count+=cc_infcom_ss(arr,idx+1,tar,psf);
        return count;
    }
    public static void main(String[] args)
    {
        int[] arr={2,3,5,7};
        int tar=10;
        System.out.println(cc_infcom_ss(arr,0,tar,""));
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
  import java.util.*;

public class cc_infinitepermutations
{
    public static int cc_infperm(int[] arr, int tar, String psf)
    {
        if(tar==0)
        {
            System.out.println(psf);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(tar-arr[i]>=0)
            {
                count+=cc_infperm(arr,tar-arr[i],psf+arr[i]);
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        int[] arr={2,3,5,7};
        int tar=10;
        System.out.println(cc_infperm(arr,tar,""));
    }
}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class cc_infinitepermutation_ss {
    public static int cc_infPer_ss(int[] arr, int idx, int tar, String psf){
        if(tar == 0 || idx == arr.length){
            if(tar == 0){
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
        int count = 0;
        int ele = arr[idx];
        if(tar - ele >= 0){
            count += cc_infPer_ss(arr, 0, tar - ele, psf + ele);
        }
        count += cc_infPer_ss(arr,idx + 1, tar, psf);
        return count;    
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};
        int tar = 10;
        System.out.println(cc_infPer_ss(arr, 0, tar, ""));
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class cc_singlecomb_subsequence
{
    public static int cc_singlecomb_ss(int[] arr, int idx, int tar, String psf)
    {
        if(tar==0 || idx==arr.length)
        {
            if(tar==0)
            {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
        int count=0;
        if(tar-arr[idx]>=0)
        {
            count+=cc_singlecomb_ss(arr,idx+1,tar-arr[idx],psf+arr[idx]);
        }
        count+=cc_singlecomb_ss(arr,idx+1,tar,psf);
        
        return count;
    }
    public static void main(String[] args)
    {
        int[] arr={2,3,5,7};
        int tar=10;
        System.out.println(cc_singlecomb_ss(arr,0,tar,""));
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class cc_singlecombinations
{
    public static int cc_sincom(int[] arr, int idx, int tar, String psf)
    {
        if(tar==0)
        {
            System.out.println(psf);
            return 1;
        }
        int count=0;
        for(int i=idx;i<arr.length;i++)
        {
            if(tar-arr[i]>=0)
            {
                count+=cc_sincom(arr,i+1,tar-arr[i],psf+arr[i]);
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        int[] arr={2,3,5,7};
        int tar=10;
        System.out.println(cc_sincom(arr,0,tar,""));
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class cc_singlepermutations
{
    public static int cc_sinperm(int[] arr, int tar, String psf)
    {
        if(tar==0)
        {
            System.out.println(psf);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            int ele=arr[i];
            if(arr[i]>0 && tar-ele>=0)
            {
                arr[i]=-arr[i];
                count+=cc_sinperm(arr,tar-ele,psf+ele);
                arr[i]=-arr[i];
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        int[] arr={2,3,5,7};
        int tar=10;
        System.out.println(cc_sinperm(arr,tar,""));
    }
}

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class cc_singlepermutations_ss
{
    public static int cc_sinperm_ss(int[] arr, int idx, int tar, String psf)
    {
        if(tar==0 || idx==arr.length)
        {
            if(tar==0)
            {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
        int count=0;
        int ele=arr[idx];
        if(arr[idx]>0 && tar-ele>=0)
        {
            arr[idx]=-arr[idx];
            count+=cc_sinperm_ss(arr,0,tar-ele,psf+ele);
            arr[idx]=-arr[idx];
        }
        count+=cc_sinperm_ss(arr,idx+1,tar,psf);
        return count;
    }
    public static void main(String[] args)
    {
        int[] arr={2,3,5,7};
        int tar=10;
        System.out.println(cc_sinperm_ss(arr,0,tar,""));
    }
}

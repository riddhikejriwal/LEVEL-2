class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int ele:nums)xor^=ele;
        
        int mask=(xor&(-xor));
        
        int a=0,b=0;
        for(int ele:nums)
        {
            if((ele&mask)==0)a^=ele;
            else b^=ele;
        }
        return new int[]{a,b};
    }
}
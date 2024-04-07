package DAY_04;
import java.util.*;


class Minimum_deletions_tomake_ArraysDIvisible{

    public static int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(numsDivide);
        
        int val=numsDivide[0];
        for(int i=1;i<numsDivide.length;i++){
            val=gcd(val,numsDivide[i]);
        }
        Arrays.sort(nums);
        int c=0;
        if(nums[0]>val) return -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>val) break;
            if(val%nums[i]!=0) c++;
            else break;
        }
        if(c==nums.length) return -1;
        return c;
    }

    static int gcd(int a, int b){
        if (a == 0) return b;
        return gcd(b % a, a);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();

        int nums[]=new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        int m=sc.nextInt();
        int numsDivide[]=new int[m];

        for(int i=0;i<m;i++){
            numsDivide[i]=sc.nextInt();
        }

        System.out.println(minOperations(nums, numsDivide));

        sc.close();
    }
}

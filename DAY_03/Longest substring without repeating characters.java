package DAY_03;

import java.util.*;
class Longest_Substring{


    public static int longestSubString(String str){
        int maxsum=0;
        int startingPoint=0;
        int endingPoint=0;

        HashSet<Character> hset=new HashSet<>();
        while(endingPoint<str.length()){
            if(!hset.contains(str.charAt(endingPoint))){
                hset.add(str.charAt(endingPoint));
                endingPoint++;
                maxsum = Math.max(hset.size(), maxsum);
            }
            else{
                hset.remove(str.charAt(startingPoint));
                startingPoint++;
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();

        int res= longestSubString(str);
        System.out.println(res);
        sc.close();

    }
}
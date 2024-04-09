package DAY_03;

import java.util.*;
 class Longest_happyPrefi {
    public static String longprefix(String s){
        int n=s.length();
        int[] lps=new int[n];
        int len=0,i=1;
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){ 
                len++;
                lps[i]=len;
                i++; 
            }
            else{
                if(len!=0){ 
                    len=lps[len-1];
                }
                else{ 
                    lps[i]=0;
                    i++;
                }
            }
        }
        int longprefixlength=lps[n-1];
        return s.substring(0,longprefixlength);
    }

    public static void main (String[] args) throws java.lang.Exception {
        
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(longprefix(s));
        sc.close();
    }
}


package DAY_03;


import java.util.Scanner;

class Shortest_palindrome{

    public static String shortPalindrome(String str){
        int i=0;
        int j=str.length()-1;
        while (j>=0) {
            if(str.charAt(i)==str.charAt(j)){
                i++;
            }
            j--;
        }
        if(i==str.length())
        return str;

        StringBuilder sb= new StringBuilder(str.substring(i)).reverse();
        return sb.toString()+str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();

        System.out.println(shortPalindrome(str) );
        sc.close();

    }
}
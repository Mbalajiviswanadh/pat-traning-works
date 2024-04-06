package DAY_03;

import java.util.*;

class Generate_paranthesis{

    public static List<String> gp(int n){
        List<String> combinations = new ArrayList<>();
        gphelper(combinations, "", 0, 0, n);
        return combinations;
    } 

    public static void gphelper(List<String> combinations, String curr, int open, int close, int n){
        if(curr.length()==2*n){
            combinations.add(curr);
            return;
        }

        if(open<n){
            gphelper(combinations, curr+"(", open+1, close, n);
        }
        if(close<open){
            gphelper(combinations, curr+")", open, close+1, n);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> res= gp(n);

        for(String i: res){
            System.out.print(i+" ");
        }

        sc.close();
    }
}
package DAY_03;

import java.util.*;

class Sorted_perms{

    public static void PrintPermutaion(String str, String perm , int idx, List<String> permutations){
        int n =str.length();

        if(n == 0){
            permutations.add(perm);
            return;
        }

        for(int i =0; i<n;i++){
            char ch=str.charAt(i);
            String newString = str.substring(0,i) + str.substring(i+1);
          
            PrintPermutaion(newString,perm+ch,idx+1, permutations);
        }

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
		
        String perm ="";
        List<String> permutations = new ArrayList<>();

        PrintPermutaion(str,perm,0, permutations);
        
        Collections.sort(permutations);
        
        for (String perm_p : permutations) {
            System.out.println(perm_p);
        }
        sc.close();
    }
}
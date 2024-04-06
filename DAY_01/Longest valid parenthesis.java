package DAY_01;

import java.util.*;
class Longest_valid_paranthesis{
  public static void main(String[] args){
	Scanner SC = new Scanner(System.in);
    int max = 0;
    Stack<Integer> stack = new Stack<>();
    String S1 = SC.next();
    stack.push(-1);
    
    for(int i=0; i<S1.length(); i++){
      char ch1 = S1.charAt(i);
      
      if(ch1 == '('){
		stack.push(i);
      }else{
		if(!stack.isEmpty()){
          stack.pop();
          if(!stack.isEmpty()){
            max = Math.max(max, i-stack.peek());
          }else{
            stack.push(i);
          }
        }
      }
      
    }
    System.out.println(max);
  }
}

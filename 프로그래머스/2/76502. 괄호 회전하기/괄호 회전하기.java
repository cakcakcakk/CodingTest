import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        for(int i=0;i<s.length();i++){
            s=s.substring(1)+s.charAt(0);
            if(correct(s)) answer++;
        }
        return answer;
    }
    
    public boolean correct(String t){
        Stack<Character> stack=new Stack<>();
        stack.push(t.charAt(0));
        
        for(int i=1;i<t.length();i++){
            if(t.charAt(i)=='['){ stack.push(t.charAt(i));}
            else if (t.charAt(i)=='{') { stack.push(t.charAt(i)); }
            else if (t.charAt(i)=='(') { stack.push(t.charAt(i)); }
            else if (t.charAt(i)==']'&&!stack.isEmpty()&&stack.peek()=='[') {stack.pop();}
            else if (t.charAt(i)=='}'&&!stack.isEmpty()&&stack.peek()=='{') {stack.pop();}
            else if (t.charAt(i)==')'&&!stack.isEmpty()&&stack.peek()=='(') {stack.pop();}
            
        }
        
        return stack.isEmpty()? true:false;

        

    }
}